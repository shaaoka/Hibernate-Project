<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>確認預定資訊</title>
</head>
<jsp:useBean id="reserve" class="com.team6.model.ReserveBean" scope="request"/>

<body>
    <h1>預定資訊確認</h1>
    <p>姓名： <%= request.getParameter("name") %></p>
    <p>電話： <%= request.getParameter("phone") %></p>
    <p>日期： <%= request.getParameter("date") %></p>
    <p>時間： <%= request.getParameter("time") %></p>
    <button onclick="confirmReservation()" value="confirmReservation" name="checkIn">確認預定</button>

    <script>
    function confirmReservation() {
        var phone = '<%= request.getParameter("phone") %>';
        var selectButton = 'confirmReservation';
        var xhr = new XMLHttpRequest();
        xhr.open('GET', '../../ReserveHomePage?phone=' + phone + '&checkin=' + selectButton, true); // 在URL中包含參數
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    alert('預定成功！');
                } else {
                    alert('預定失敗，請稍後再試。');
                }
            }
        };
        xhr.send();
    }
    </script>
<a href="./reservation/html/ReserveHomePage.html"><button>返回</button></a>
</body>
</html>
