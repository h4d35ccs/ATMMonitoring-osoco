google.load('visualization', '1', {'packages': ['geochart']});
google.setOnLoadCallback(drawRegionsMap);

    function drawRegionsMap() {
      var data = google.visualization.arrayToDataTable([
        ['Country', 'ATM'],
        ['Germany', 200],
        ['United States', 300],
        ['Brazil', 400],
        ['Canada', 500],
        ['France', 600],
        ['ES', 700]
      ]);

      var options = {};

      var chart = new google.visualization.GeoChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }

google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['SO', 'Numero'],
          ['WXP',     11],
          ['W7',      2],
          ['W8',  2],
          ['WNT', 2],
        ]);

        var options = {
          title: 'ATM Sistema Operativo',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }

google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart2);
      function drawChart2() {
        var data = google.visualization.arrayToDataTable([
          ['SO', 'Numero'],
          ['WXP',     11],
          ['W7',      2],
          ['W8',  2],
          ['WNT', 2],
        ]);

        var options = {
          title: 'ATM Sistema Operativo MADRID',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }

google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart3);
      function drawChart3() {
        var data = google.visualization.arrayToDataTable([
          ['IE Versión', 'ATM'],
          ['IE8', 130000], 
          ['IE9', 200000],
          ['IE10', 5000] 
        ]);

        var options = {
          title: 'Versiones de IE por ATM',
          legend: 'none',
          pieSliceText: 'label',
          slices: {  4: {offset: 0.2},
                    12: {offset: 0.3},
                    14: {offset: 0.4},
                    15: {offset: 0.5},
          },
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }

google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart5);
      function drawChart5() {
        var data = google.visualization.arrayToDataTable([
          ['Años', 'WXP', 'W7'],
          ['2011',  1000,      400],
          ['2012',  1170,      460],
          ['2013',  1200,      520],
          ['2014',  1030,      740]
        ]);

        var options = {
          title: 'S.O. Madrid',
          hAxis: {title: 'Años', titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('Graph01'));
        chart.draw(data, options);
      }

google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart6);
      function drawChart6() {
        var data = google.visualization.arrayToDataTable([
          ['Años', 'WXP', 'W7'],
          ['2011',  1000,      400],
          ['2012',  1170,      460],
          ['2013',  1200,      520],
          ['2014',  1030,      740]
        ]);

        var options = {
          title: 'S.O. Barcelona',
          hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('Graph02'));
        chart.draw(data, options);
      }

google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart7);
      function drawChart7() {
        var data = google.visualization.arrayToDataTable([
          ['Años', 'WXP', 'W7'],
          ['2011',  1000,      400],
          ['2012',  1170,      460],
          ['2013',  1200,      520],
          ['2014',  1030,      740]
        ]);

        var options = {
          title: 'S.O. Valencia'
        };

        var chart = new google.visualization.LineChart(document.getElementById('Graph03'));
        chart.draw(data, options);
      }
google.load('visualization', '1', {'packages': ['geochart']});
     google.setOnLoadCallback(drawMarkersMap);

      function drawMarkersMap() {
      var data = google.visualization.arrayToDataTable([
        ['Ciudad',   'ATM', 'Area'],
        ['Madrid',      2761477,    1285.31],
        ['Barcelona',     1324110,    181.76],
        ['Valencia',    959574,     117.27],
        ['Bilbao',     907563,     130.17],
        ['Melilla',     907563,     130.17],
      ]);

      var options = {
        region: 'ES',
        displayMode: 'markers',
        colorAxis: {colors: ['green', 'blue']}
      };

      var chart = new google.visualization.GeoChart(document.getElementById('Graph04'));
      chart.draw(data, options);
    }