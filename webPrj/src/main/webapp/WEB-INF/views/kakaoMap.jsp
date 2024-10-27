<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>영화관 마커 생성하기</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <style>
      #map {
        width: 100%;
        height: 100vh;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>

    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=69812f8c98c18be411e99af0f920692c"
    ></script>
    <script>
 // 위치 정보 가져오기 및 지도 생성
    window.navigator.geolocation.getCurrentPosition(
      function (position) {
        let latitude = position.coords.latitude;
        let longitude = position.coords.longitude;
        console.log("위도: " + latitude + ", 경도: " + longitude);

        // 지도 생성 후 마커를 로드하는 함수 호출
        createMap(latitude, longitude);
      },
      function (error) {
        console.error("위치 정보를 가져오지 못했습니다: " + error.message);
      }
    );

    // 지도 생성 및 마커 로드 함수
    function createMap(latitude, longitude) {
      let mapContainer = document.getElementById('map');
      let mapOption = {
        center: new kakao.maps.LatLng(latitude, longitude), // 현재 위치를 중심으로 설정
        level: 5, // 확대 레벨
      };

      // Kakao 지도 생성
      let map = new kakao.maps.Map(mapContainer, mapOption);

      // 지도가 생성된 후에 마커를 로드
      sendLocation(latitude, longitude, map);
    }

    // 서버에 위치 정보를 보내고 마커를 로드하는 함수
    function sendLocation(latitude, longitude, map) {
      let url =
        "/webPrj/getLocations?latitude=" +
        encodeURIComponent(latitude) +
        "&longitude=" +
        encodeURIComponent(longitude);

      $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function (data) {
          console.log("마커 데이터:", data);
          loadMarkers(data, map); // 마커 로드
        },
        error: function (err) {
          console.error("마커 데이터를 가져오지 못했습니다:", err);
        },
      });
    }

    // 마커를 지도에 표시하는 함수
    function loadMarkers(data, map) {
      let locations = data.documents;
      console.log("로드마커 실행됨:", locations);

      locations.forEach(function (location) {
        let marker = new kakao.maps.Marker({
          position: new kakao.maps.LatLng(location.y, location.x),
          map: map,
        });

        // 마커 클릭 이벤트 등록
        kakao.maps.event.addListener(marker, "click", function () {
          alert("장소: " + location.place_name);
        });
      });
    }
    </script>
  </body>
</html>
