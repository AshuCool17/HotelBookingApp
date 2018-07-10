<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/static/css/style.css" />
<title><spring:message code="menu.homePage.viewLowPriceHotel" /></title>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript">

	tableContent = "";
	$(function(){
	$("#selectCity").change(function() {
		getAllHotelsInACity();
	});
});


	function getAllHotelsInACity() {
		var cityValue = $("#selectCity").val();
		$.ajax({
			url : 'viewAllHotels?city='+cityValue,
			type : 'post',
			data : 1,
			dataType : 'json',
			success : function(hotels) {
				if($.isEmptyObject(hotels)){
					displayNoRecords();
				}else{
				generateHeader();
				$.each(hotels, function(index, hotel) {
					display(index, hotel);
				});
				generateFooter();
			}},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("error" + jqXHR.responseText);
				window.location = "home?errorMessage="
						+ jqXHR.responseText;
			}
		});
		
}

/*
 * generate table header row
 */
function generateHeader() {
	tableContent = "<table border='1'><tr><td>HOTEL_NAME</td><td>NUMBER_OF_ROOMS_AVAILABLE</td><td>STAR_RATING</td><td>TARIFF_PER_DAY</td></tr>";
}

/*
 * generate table footer
 */
function generateFooter() {
	tableContent += "</table>";
	$("#hotelTable").html(tableContent);
}

/*
 * Display each hotel in tabular fashion  
 */
function display(index, hotel) {
		tableContent += "<tr><td>"
			+ hotel.name + "</td><td>" + hotel.roomsAvailable
			+ "</td><td>" + hotel.rating + "</td><td>" + hotel.tariff + "</td></tr>";
}

function displayNoRecords(){
	tableContent = "<table border='1'><tr><td>No hotels found</td></tr></table>";
	$("#hotelTable").html(tableContent);
}

</script>
</head>
<body>
<div class="menu">    	   
    <div class="welcome-message">
        <div class="wrap-info">
            <div class="information">
            	<p class="animated header"><spring:message code="menu.homePage.viewLowPriceHotel" /></p>
		<table id="viewHotelsId">
			<tr>
				<td><p><spring:message code="menu.bookingPage.city" />
				<form:select cssClass="dropdownCss" path="cityName" id="selectCity">
						<form:option cssClass="dropdownCss" value="-1">Select City: </form:option>
						<c:forEach items="${cities}" var="city">
							<form:option cssClass="dropdownCss" value="${city.name}">${city.name}</form:option>
						</c:forEach>
    			</form:select>
				</p></td>
				<td><form:errors path="cityName" /></td>
			</tr>
			<tr>
			
			</tr>
				<tr><td><div id="hotelTable"></div>
				</td></tr>
				<tr><td><a href="home"><spring:message code="menu.bookingPage.cancel" /></a></td></tr>
		<tr><td><form:errors path="hotelName" /></td></tr>
		</table>
		</div>
</div>
</div>
</div>
</body>
</html>