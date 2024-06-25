<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.team6.model.ReserveBean, com.team6.model.ReserveDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>報到資訊</title>
<style>
    body {
        background-color: #f0f0f0;
        font-family: Arial, sans-serif; 
        text-align: center; 
    }
    table {
        width: 80%;
        margin: 0 auto; 
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid #ddd; 
        padding: 8px; 
        text-align: left; 
    }
    th {
        background-color: #f2f2f2; 
    }
</style>
</head>

<body>
<h2>報到資訊</h2>
<table>
    <thead>
        <tr>
            <th>預訂姓名</th>
            <th>預訂日期</th>
            <th>預訂時間</th>
            <th>電話號碼</th>
            <th>報到完成</th>
            <th>刪除</th>
        </tr>
    </thead>
    <tbody>
        <% List<ReserveBean> selectName = (List<ReserveBean>) request.getAttribute("selectName");
        for (ReserveBean selectNames : selectName) { %>
                <td><%= selectNames.getReservation_name() %></td>
                <td><%= selectNames.getReservation_date() %></td>
                <td><%= selectNames.getReservation_time() %></td>
                <td><%= selectNames.getPhone() %></td>
                <td><button type="button" onclick="checkInSuccess('<%= selectNames.getReservation_id() %>')">報到完成</button></td>
                <td><button type="button" onclick="deleteCheckIn('<%= selectNames.getReservation_id() %>')">刪除</button></td>
            </tr>
        <% } %>
    </tbody>
</table>
<script>
	function checkInSuccess(reservationId) {
	    var xhr = new XMLHttpRequest();
	    xhr.open('POST', './ReserveHomePage', true);
	    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState === XMLHttpRequest.DONE) {
	            if (xhr.status === 200) {
	                alert('報到成功！');
	                location.reload(); // 重新載入頁面
	            } else {
	                alert('報到失敗，請稍後再試。');
	            }
	        }
	    };
	    xhr.send('action=checkInSuccess&reservationId=' + encodeURIComponent(reservationId));
	}

	function deleteCheckIn(reservationId) {
	    var xhr = new XMLHttpRequest();
	    xhr.open('POST', './ReserveHomePage', true);
	    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState === XMLHttpRequest.DONE) {
	            if (xhr.status === 200) {
	                // 刪除成功
	                alert('刪除報到資訊成功！');
	                location.reload(); // 重新載入頁面
	            } else {
	                // 刪除失敗
	                alert('刪除報到資訊失敗，請稍後再試。');
	            }
	        }
	    };
	    xhr.send('action=deleteCheckIn&reservationId=' + encodeURIComponent(reservationId));
	}

	
</script>
<a href="./reservation/html/ReserveHomePage.html"><button>返回</button></a>
</body>
</html>
