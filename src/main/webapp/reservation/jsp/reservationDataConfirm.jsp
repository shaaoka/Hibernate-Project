<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.team6.model.ReserveBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認訂位資訊</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }
    table {
        border-collapse: collapse;
        width: 80%;
        margin: 0 auto;
    }
    th, td {
        border: 1px solid #dddddd;
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
    <h1>確認訂位資訊</h1>
    <table>
        <thead>
            <tr>
                <th>編號</th>
                <th>日期</th>
                <th>時間</th>
                <th>人數</th>
                <th>姓名</th>
                <th>電話</th>
                <th>備註</th>
                <th>確認</th>
                <th>刪除</th>
                
            </tr>
        </thead>
        <tbody>
            <% List<ReserveBean> reservations = (List<ReserveBean>) request.getAttribute("selectReservationStatus");
               int index = 1;
               for (ReserveBean reservation : reservations) { %>
                <tr>
                    <td><%= index++ %></td>
                    <td><%= reservation.getReservation_date() %></td>
                    <td><%= reservation.getReservation_time() %></td>
                    <td><%= reservation.getNumberOfPeople() %></td>
                    <td><%= reservation.getReservation_name() %></td>
                    <td><%= reservation.getPhone() %></td>
                    <td><%= reservation.getSpecial_requests() %></td>
                    <td><button onclick="confirmReservation('<%= reservation.getReservation_id() %>')">確認</button></td>
                    <td><button onclick="deleteReservation('<%= reservation.getReservation_id() %>')">刪除</button></td>
                    
                </tr>
            <% } %>
        </tbody>
    </table>
    
	<script>
		function confirmReservation(reservationId) {
		    var confirmed = confirm("確定要確認此訂位嗎？");
		    if (confirmed) {
		        var xhr = new XMLHttpRequest();
		        xhr.open('POST', './ReserveHomePage', true);
		        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		        xhr.onreadystatechange = function() {
		            if (xhr.readyState === XMLHttpRequest.DONE) {
		                if (xhr.status === 200) {
		                    location.reload();
		                } else {
		                    alert('預定失敗，請稍後再試。');
		                }
		            }
		        };
		        xhr.send('action=confirmReservation&reservationId=' + reservationId);
		    }
		}
	
		function deleteReservation(reservationId) {
		    var confirmed = confirm("確定要刪除此訂位嗎？");
		    if (confirmed) {
		        var xhr = new XMLHttpRequest();
		        xhr.open('POST', './ReserveHomePage', true);
		        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		        xhr.onreadystatechange = function() {
		            if (xhr.readyState === XMLHttpRequest.DONE) {
		                if (xhr.status === 200) {
		                    location.reload();
		                } else {
		                    alert('刪除失敗，請稍後再試。');
		                }
		            }
		        };
		        xhr.send('action=deleteReservation&reservationId=' + reservationId);
		    }
		}	
	</script>
<a href="./reservation/html/ReserveHomePage.html"><button>返回</button></a>
</body>
</html>
