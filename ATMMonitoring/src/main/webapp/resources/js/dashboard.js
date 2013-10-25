var dashboardUrl = 'dashboard/charts';
var chartUrl = 'dashboard/chart';
var updateChartPositionUrl = 'dashboard/updateChartPosition';
var hideChartUrl = 'dashboard/hideChart';
var showChartUrl = 'dashboard/showChart';

var googleChartType = {
    'PIE_CHART': 'google.visualization.PieChart',
    'BAR_CHART': 'google.visualization.BarChart',
    'COLUMN_CHART': 'google.visualization.ColumnChart',
    'GEO_CHART': 'google.visualization.GeoChart'
};

Array.prototype.move = function (old_index, new_index) {
    this.splice(new_index, 0, this.splice(old_index, 1)[0]);
};

google.load('visualization', '1', {'packages': ['corechart', 'geochart']});

$(function() {
    initDashboardModel();
	$(".iframe").colorbox({iframe:true, width:"640px", height:"90%"});
});

// Model ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

var dashboardModel = {}

function getVisibleWidgetModelById(widgetId) {
    for (var i = 0; i < dashboardModel.visibleCharts.length; i++) {
        if (dashboardModel.visibleCharts[i].id == widgetId) {
            return dashboardModel.visibleCharts[i];
        }
    }
}

function indexOfVisibleWidget(widgetId) {
    for (var i = 0; i < dashboardModel.visibleCharts.length; i++) {
        if (dashboardModel.visibleCharts[i].id == widgetId) {
            return i;
        }
    }
    return -1;
}

function indexOfHiddenWidget(widgetId) {
    for (var i = 0; i < dashboardModel.hiddenCharts.length; i++) {
        if (dashboardModel.hiddenCharts[i].id == widgetId) {
            return i;
        }
    }
    return -1;
}

function removeVisibleWidget(widgetId) {
    var index = indexOfVisibleWidget(widgetId);
    var widget = dashboardModel.visibleCharts[index];
    dashboardModel.visibleCharts.splice(index, 1);
    return widget;
}

function removeHiddenWidget(widgetId) {
    var index = indexOfHiddenWidget(widgetId);
    var widget = dashboardModel.hiddenCharts[index];
    dashboardModel.hiddenCharts.splice(index, 1);
    return widget;
}

function addHiddenWidget(widget) {
    dashboardModel.hiddenCharts.push(widget);
}

function addVisibleWidget(widget) {
    dashboardModel.visibleCharts.push(widget);
}

function moveVisibleChart(oldPosition, newPosition) {
    console.log("Moving widget from " + oldPosition + " to " + newPosition);
    console.log("old: " + dashboardModel.visibleCharts);
    dashboardModel.visibleCharts.move(oldPosition, newPosition);
    console.log("new: " + dashboardModel.visibleCharts);
}

// Controllers ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

function initDashboardModel() {
    $.ajax({
        url: dashboardUrl,
        dataType: "json",
        async: true
    }).fail(function(xhr, ajaxOptions, thrownError) {
        console.error("Error " + xhr.status + ": " + thrownError);
    }).done(function(data) {
        dashboardModel = data;
        onLoadDashboard();
    });
}

function initSortableCharts() {
    $("#sortable").sortable({
        placeholder: "ui-state-highlight",
        start: function(event, ui) {
            $(ui.item).data("startIndex", ui.item.index());
        },
        stop: function(event, ui) {
            var startIndex = $(ui.item).data("startIndex");
            var endIndex = $(ui.item).index();
            moveVisibleChart(startIndex, endIndex);
            onMovedVisibleChart($(ui.item).attr("id"), startIndex, endIndex);
        }
    });
    $("#sortable").disableSelection();
}

function hideWidget(widgetId) {
    var widget = removeVisibleWidget(widgetId);
    addHiddenWidget(widget);
    onHiddenWidget(widgetId);
}

function showWidget(widgetId) {
    var widget = removeHiddenWidget(widgetId);
    addVisibleWidget(widget);
    onVisibleWidget(widgetId);
}

function closeChartsMenu() {
    $("#myCharts").hide();
    $("#myCharts").parent().find("div.txt").addClass("content_hide");
}

// Event Handlers++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

function onLoadDashboard() {
    drawCharts();
    initSortableCharts();
}

function onChartsMenuDrawed() {
    $("#myCharts li.on").click(function(event) {
        event.preventDefault();
        var widgetId = $(this).attr("id");
        showWidget(widgetId);
        closeChartsMenu();
    });
}

function onChartDrawed(chart) {
    var widgetId = $(chart).attr("id");
    var widget = getVisibleWidgetModelById(widgetId);
    $.ajax({
        url: chartUrl,
        data: {
            'widgetId': widgetId
        },
        dataType: "json",
        async: true
    }).fail(function(xhr, ajaxOptions, thrownError) {
        console.error("Error " + xhr.status + ": " + thrownError);
    }).done(function(data) {
        var chartData = new google.visualization.DataTable(data);
        var graph = $(chart).find("div.graph")[0];
        var googleChart = eval("new " + googleChartType[widget.type] + "(graph)");
        var options = {
            'title': widget.title,
            'region': 'ES',
            'displayMode': 'markers'
        };
        googleChart.draw(chartData, options);
    });

    $(chart).find(".ocultable").hide();
    $(chart).find(".close").click(function() {
        hideWidget(widgetId);
	});
    drawChartsMenu();
}

function onHiddenWidget(widgetId) {
    $.post(
        hideChartUrl,
        {
            widgetId: widgetId
        }
    );
    drawChartsMenu();
    $("#sortable li#" + widgetId).hide('slow');
    $("#sortable li#" + widgetId).remove();
}

function onVisibleWidget(widgetId) {
    $.post(
        showChartUrl,
        {
            widgetId: widgetId
        }
    );
    var widget = getVisibleWidgetModelById(widgetId);
    drawChart(widget);
}

function onMovedVisibleChart(widgetId, oldPosition, newPosition) {
    if (oldPosition != newPosition) {
        $.post(
            updateChartPositionUrl,
            {
                widgetId: widgetId,
                oldPosition: oldPosition,
                newPosition: newPosition
            }
        );
    }
    drawChartsMenu();
}

// View +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

var transforms = {
    "chartsHiddenMenu": [ { tag: 'li', class: 'on', id: "${id}", html: "${title}" } ],
    "chartsVisibleMenu": [ { tag: 'li', class: 'off', id: "${id}", html: "${title}" } ],
    "charts": [ { tag: 'li', class: 'chart ui-state-default', id: "${id}",
                  children: [
                      { tag: 'div', class: 'content',
                        children: [
                            { tag: 'div', class: 'icons_bg',
                              children: [
                                  { tag: 'div', class: 'close',
                                    children: [ { tag: 'span', html: 'cerrar' } ] },
                                  { tag: 'nav', class: 'icons_menu desplegable',
                                    children: [ { tag: 'div', class: 'icon16 config content_hide txt',
                                                  children: [ { tag: 'span', html: 'Opciones' } ] },
                                                { tag: 'ul', class: 'ocultable',
                                                  children: [ { tag: 'li', children: [ { tag: 'a', href: '#', html: 'Editar'} ] },
                                                              { tag: 'li', children: [ { tag: 'a', href: '#', html: 'Compartir'} ] },
                                                            ]
                                                }
                                              ]
                                  }
                              ]
                            },
                            { tag: 'div', class: 'graph' }
                        ]
                      }
                  ]
                }
              ]
};

function drawChartsMenu() {
    $("#myCharts li").remove();
    $("#myCharts").json2html(dashboardModel.hiddenCharts, transforms.chartsHiddenMenu);
    $("#myCharts").json2html(dashboardModel.visibleCharts, transforms.chartsVisibleMenu);
    onChartsMenuDrawed();
}

function drawCharts() {
    for (var i = 0; i < dashboardModel.visibleCharts.length; i++) {
        var widget = dashboardModel.visibleCharts[i];
        drawChart(widget);
    }
}

function drawChart(widget) {
    $("#sortable").json2html(widget, transforms.charts);
    onChartDrawed($("#sortable li#" + widget.id));
}




function initCharts() {
    $("#sortable").sortable({
        placeholder: "ui-state-highlight",
        start: function(event, ui) {
            $(ui.item).data("startIndex", ui.item.index());
        },
        stop: function(event, ui) {
            updateChartIndex(ui.item);
        }
    });
	$("#sortable").disableSelection();
    $('#sortable li .close').click(function() {
        var chart = $(this).parent().parent().parent();
        var widgetId = $(chart).attr("id");
        hideWidget(widgetId);
	});
}

function initChartsMenu() {
    $("#myCharts li.on").click(function() {
        var widgetId = $(this).data("widgetId");
        showWidget(widgetId);
    });
}
