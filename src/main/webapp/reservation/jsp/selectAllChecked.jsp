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
            <th>用餐人數</th>
            <th>電話號碼</th>
            <th>刪除</th>
        </tr>
    </thead>
    <tbody>
        <% List<ReserveBean> selectAllChecked = (List<ReserveBean>) request.getAttribute("selectAllChecked");
        for (ReserveBean selectAllCheckeds : selectAllChecked) { %>
                <td><%= selectAllCheckeds.getReservation_name() %></td>
                <td><%= selectAllCheckeds.getReservation_date() %></td>
                <td><%= selectAllCheckeds.getReservation_time() %></td>
                <td><%= selectAllCheckeds.getNumberOfPeople() %></td>                
                <td><%= selectAllCheckeds.getPhone() %></td>
                <td><button type="button" onclick="deleteCheckIn('<%= selectAllCheckeds.getReservation_id() %>')">已離開</button></td>
            </tr>
        <% } %>
    </tbody>
</table>
<script>
	function deleteCheckIn(reservationId) {
	    var xhr = new XMLHttpRequest();
	    xhr.open('POST', './ReserveHomePage', true);
	    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState === XMLHttpRequest.DONE) {
	            if (xhr.status === 200) {
	                // 刪除成功
	                alert('刪除成功！');
	                location.reload(); // 重新載入頁面
	            } else {
	                // 刪除失敗
	                alert('刪除失敗，請稍後再試。');
	            }
	        }
	    };
	    xhr.send('action=deleteCheckIn&reservationId=' + encodeURIComponent(reservationId));
	}
</script>
<a href="./reservation/html/ReserveHomePage.html"><button>返回</button></a>
</body>