<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.team6.model.ReserveBean, com.team6.model.ReserveDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReservationData</title>
<style>
    body {
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
            <th>修改</th>
            <th>刪除</th>
        </tr>
    </thead>
    <tbody>
        <% List<ReserveBean> reservations = (List<ReserveBean>) request.getAttribute("reservations");
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
				<td>
					<button type="button" onclick="updateReservation('<%= reservation.getReservation_id() %>')">修改</button>
						<select id="updateSelect">
					        <option value="number">人數</option>
					        <option value="date">日期</option>
					        <option value="time">時間</option>
					    </select>
			    </td>
				<td><button type="button" onclick="deleteReservation('<%= reservation.getReservation_id() %>')">刪除</button></td>
            </tr>
        <% } %>
    </tbody>
</table>


<script>
		function updateReservation(reservationId) {
		    var selectedOption = document.getElementById('updateSelect').value;
		
		    switch(selectedOption) {
		        case 'number':
		            var newNumberOfPeople = prompt("請輸入新的人數：");
		            if(newNumberOfPeople !== null && newNumberOfPeople !== '') {
		                updateNumberOfPeople(reservationId, newNumberOfPeople);
		            } else {
		                alert("請輸入有效的人數");
		            }
		            break;
		        case 'date':
		            var newDate = prompt("請輸入新的日期（格式：YYYY-MM-DD）：");
		            if(newDate !== null && newDate !== '') {
		                updateReservationDate(reservationId, newDate);
		            } else {
		                alert("請輸入有效的日期");
		            }
		            break;
		        case 'time':
		            var newTime = prompt("請輸入新的時間（格式：HH:MM）：");
		            if(newTime !== null && newTime !== '') {
		                updateReservationTime(reservationId, newTime);
		            } else {
		                alert("請輸入有效的時間");
		            }
		            break;
		        default:
		            alert("請選擇有效選項");
		            break;
		    }
		}

		
		function updateNumberOfPeople(reservationId, newNumberOfPeople) {
		    var xhr = new XMLHttpRequest();
		    xhr.open('POST', './ReserveHomePage', true);
		    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xhr.send('action=updateNumberOfPeople&reservationId=' + encodeURIComponent(reservationId) + '&newNumberOfPeople=' + encodeURIComponent(newNumberOfPeople));
		
		    xhr.onload = function() {
		        if (xhr.status === 200) {
		            location.reload();
		        } else {
		            console.error('更新失敗: ' + xhr.statusText);
		        }
		    };
		}
		
		function updateReservationDate(reservationId, newDate) {
		    var xhr = new XMLHttpRequest();
		    xhr.open('POST', './ReserveHomePage', true);
		    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xhr.send('action=updateReservationDate&reservationId=' + encodeURIComponent(reservationId) + '&newDate=' + encodeURIComponent(newDate));
		
		    xhr.onload = function() {
		        if (xhr.status === 200) {
		            location.reload();
		        } else {
		            console.error('更新失敗: ' + xhr.statusText);
		        }
		    };
		}
		function updateReservationTime(reservationId, newTime) {
		    var xhr = new XMLHttpRequest();
		    xhr.open('POST', './ReserveHomePage', true);
		    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xhr.send('action=updateReservationTime&reservationId=' + encodeURIComponent(reservationId) + '&newTime=' + encodeURIComponent(newTime));

		    xhr.onload = function() {
		        if (xhr.status === 200) {
		            location.reload();
		        } else {
		            console.error('更新失敗: ' + xhr.statusText);
		        }
		    };
		}
		
		function deleteReservation(reservationId) {
		    if (confirm("確定要刪除此訂位資訊嗎？")) {
		        var xhr = new XMLHttpRequest();
		        xhr.open('POST', './ReserveHomePage', true);
		        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		        xhr.send('action=deleteReservation&reservationId=' + encodeURIComponent(reservationId));

		        xhr.onload = function() {
		            if (xhr.status === 200) {
		                location.reload();
		            } else {
		                console.error('刪除失敗: ' + xhr.statusText);
		            }
		        };
		    }
		}


</script>
<a href="./reservation/html/ReserveHomePage.html"><button>返回</button></a>
</body>
</html>
