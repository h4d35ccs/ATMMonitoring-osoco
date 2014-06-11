$.jstree.defaults.search.fuzzy = false;
$.jstree.defaults.search.show_only_matches = true;

var NetworkTree = {
		
		
		networkRestServiceURl:"",
		htmlElementId:"",
		htmlSerchInputId:"",
		jsTreePlugins: [ "search", "contextmenu" ],
		originalJsonKeyIdElement: "nodeUrlAndPort",
		originalJsonKeyIconElement: "lastcomunicationInMilisecAt",
		originalJsonKeyDataElement: "nodeInfo",
		normalServerIcon: "",
		idleServerIcon: "",
		rootServerIcon: "",
		rootIconKeyWordToAvoidMenu: "Root",
		localJsonString:"",
		remoteJsonString:"",
		nodeIddleSeconds:300,
		
		extraMenuHandler:function(node,items){
			
		},
		
		customMenuItems: {},
		
		closeAll:function(){
				
			$(this.htmlElementId).jstree("close_all");
		},
		
		openAll:function(){
			
			$(this.htmlElementId).jstree('open_all');
		},
	
		reload:function(){
			$(this.htmlElementId).jstree("refresh");
			
		},
		
		setupHtmlElements: function(treeDivElementId,searchInputId, normalIcon, idleIcon,rootIcon){
			this.htmlElementId =treeDivElementId;
			this.htmlSerchInputId = searchInputId;
			this.normalServerIcon = normalIcon;
			this.idleServerIcon = idleIcon;
			this.rootServerIcon = rootIcon;
		},
		
		startJStreeRemote: function (menuItems,remoteRestUrl) {
			this.networkRestServiceURl = remoteRestUrl;
			this.setupJsTree();
			this.setupJsTreeSearch();
			this.customMenuItems = menuItems;
			
		},
		

		startJStreeLocal: function (jsonString,menuItems) {
			this.localJsonString = jsonString;
			this.setupJsTree();
			this.setupJsTreeSearch();
			this.customMenuItems = menuItems;
		},

		setupJsTree: function() {
			
			$(this.htmlElementId).jstree({
				'core' : {
					'data' : function(obj, cb) {

						cb.call(this, NetworkTree.getTreeJson());
					}
				},
				"plugins" : this.jsTreePlugins,
				"contextmenu" : {
					items : this.customMenu,
				}

			});
		},

		setupJsTreeSearch: function () {
			var inputSearch = $(this.htmlSerchInputId);
			var jsTreeElement = $(this.htmlElementId);
			var to = false;
			inputSearch.keyup(function() {
				if (to) {
					clearTimeout(to);
				}
				to = setTimeout(function() {
					var v = inputSearch.val();
					jsTreeElement.jstree(true).search(v);
				}, 250);
			});

		},
		
		refreshRemote: function(){
			this.setupJsTree();
		},
		
		refreshLocal: function(stringJson){
			this.startJStree(stringJson,this.customMenuItems);
			this.setupJsTree();
		},
		
		transformIntoJsTreeJSON: function (networkJsonString) {
			
			networkJsonString = this.replaceJSONKeyNames(networkJsonString);
			var idSections = networkJsonString.match(/\"id\":\"[0-9\.:]*\"/g);
			networkJsonString = this.addTextSectionNextToIdInJSON(networkJsonString,
					idSections);
			var networkJson = this.parseJSONStringToObjectAndAddIcons(networkJsonString);
			return networkJson;
		},

		getTreeJson: function () {
			var stringJson ="";
			if(this.localJsonString == ""){
				
				 this.getRemoteJsonString();
				 stringJson = this.remoteJsonString;
				
			}else{
				
				stringJson = this.localJsonString;
			}
			
			var jsTreeJson = this.transformIntoJsTreeJSON(stringJson);
			return jsTreeJson;

		},
		
		getRemoteJsonString : function(){
			$.ajaxSetup({async: false});
			
			$.getJSON(NetworkTree.networkRestServiceURl,function(data) {
				
				NetworkTree.remoteJsonString = JSON.stringify(data);

			});
			 
		},

		replaceAll: function (find, replace, str) {
			return str.replace(new RegExp(find, 'g'), replace);
		},

		replaceJSONKeyNames: function (networkJsonString) {

			networkJsonString = this.replaceAll(this.originalJsonKeyIdElement, "id",
					networkJsonString);
			networkJsonString = this.replaceAll(this.originalJsonKeyIconElement,
					"icon", networkJsonString);
			networkJsonString = this.replaceAll(this.originalJsonKeyDataElement, "data",
					networkJsonString);

			return networkJsonString;
		},

		addTextSectionNextToIdInJSON: function (networkJsonString, idSections) {

			for (var i = 0; i < idSections.length; i++) {

				var idSection = idSections[i];
				var textSection = idSection;
				textSection = this.replaceAll("id", "text", textSection);
				var newIdSection = idSection + "," + textSection;
				networkJsonString = this.replaceAll(idSection, newIdSection,
						networkJsonString);
			}

			return networkJsonString;
		},

		parseJSONStringToObjectAndAddIcons: function (networkJsonString) {
			var serverIcon = this.normalServerIcon;
			var idleServer = this.idleServerIcon;
			var rootServer = this.rootServerIcon;
			var iddleSeconds = this.nodeIddleSeconds;
			
			var networkJson = JSON.parse(networkJsonString,
					function replacer(key, value) {
						var now = new Date();

						if (key == "icon" && value != 0) {

							var lastConnection = new Date(value);
							var seconds = (now.getTime() - lastConnection
									.getTime()) / 1000;

							if (seconds < iddleSeconds) {
								
								value = serverIcon;

							} else {
								value = idleServer;
							}
						} else if (key == "icon" && value == 0) {
							
							value = rootServer;
						}

						return value;
					});

			return networkJson;
		},

		customMenu: function (node) {
			
			var items = NetworkTree.customMenuItems(node);

			var iconText = $(node)[0].icon;
	
			if (iconText.indexOf(NetworkTree.rootIconKeyWordToAvoidMenu) > -1) {

				items = {};
			}
			
			NetworkTree.extraMenuHandler(node,items);
			

			return items;
		}
		
};