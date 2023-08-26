<html>
<head>
    <meta charset="UTF-8">
    <title>간단한 지도 표시하기</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=6msw8dshkf"></script>
</head>
<body>
<div id="map" style="width:100%;height:400px;"></div>

<script>
var mapOptions = {
    center: new naver.maps.LatLng(37.3595704, 127.105399),
    zoom: 10
};

var map = new naver.maps.Map('map', mapOptions);
</script>
</body>
</html>