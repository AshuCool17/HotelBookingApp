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
<!-- Load jQuery from Google's CDN -->
    <!-- Load jQuery UI CSS  -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    
    <!-- Load jQuery JS -->
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <!-- Load jQuery UI Main JS  -->
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    
    <!-- Load SCRIPT.JS which will create datepicker for input field  -->
    <!-- Javascript -->
      <script>         
         $(function () {
        	    $("#checkinDate").datepicker({
        	        onSelect: function (selected) {
        	            var dt = new Date(selected);
        	            dt.setDate(dt.getDate() + 1);
        	            $("#checkoutDate").datepicker("option", "minDate", dt);
        	        }
        	    });
        	    $("#checkoutDate").datepicker({
        	        onSelect: function (selected) {
        	            var dt = new Date(selected);
        	            dt.setDate(dt.getDate() - 1);
        	            $("#checkinDate").datepicker("option", "maxDate", dt);
        	        }
        	    });
        	});
      </script>
      <script type="text/javascript">
	var tableContent ="";
	$(function() {
		$("#selectCity").change(getAllHotelsInACity);
	});

	/*
	 * get all hotels for a cityhotel
	 */
	function getAllHotelsInACity() {
		
		var cityValue = $("#selectCity").val();
		$.ajax({
			url : 'getHotel?city='+cityValue,
			type : 'post',
			data : 1,
			dataType : 'json',
			success : function(hotels) {
				var hotelName = $("#hotelName");
				var option = "";
				hotelName.empty();
				option = "<option value="+-1+"> Select Hotel: </option>";
				hotelName.append(option);
				$.each(hotels, function(index, hotel) {
                    option =  "<option value='" + hotel.name + "'>" +hotel.name + "</option>";
                    hotelName.append(option);
				});
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("error" + jqXHR.responseText);
				window.location = "home?errorMessage="
						+ jqXHR.responseText;
			}
		});
		
	}
	</script>
<title><spring:message code="menu.homePage.bookARoom" /></title>
</head>
<body>
<div id="hotelDetails">		
</div>

<div class="menu">    	   
    <div class="welcome-message">
        <div class="wrap-info">
            <div class="information">
            <p class="animated header"><spring:message code="menu.homePage.bookARoom" /></p>
<form:form commandName="booking" action="bookHotel" id="bookingForm">
<table>
			<tr>
				<td><p><spring:message code="menu.bookingPage.city" /></p></td>
				<td><form:select cssClass="dropdownCss" path="cityName" id="selectCity">
						<form:option value="-1">Select City: </form:option>
						<c:forEach items="${cities}" var="city">
							<form:option value="${city.name}">${city.name}</form:option>
						</c:forEach>
    			</form:select></td>
				<td><form:errors path="cityName" cssClass="error"/></td>
			</tr>
			
			<tr><td><p class="animated"><spring:message code="menu.bookingPage.hotel" /></p></td>
				<td><form:select cssClass="dropdownCss" path="hotelName" id="hotelName">
				<form:option value="-1">Select Hotel: </form:option>
				<c:forEach items="${hotelsOfCity}" var="hotel">
							<form:option value="${hotel.name}">${hotel.name}</form:option>
						</c:forEach>
    </form:select></td>
<td><form:errors path="hotelName" cssClass="error"/></td></tr>
<tr>
<td>
<p class="animated"><spring:message code="menu.bookingPage.checkinDate" /></p>
</td>
<td><form:input cssClass="dropdownCss" path="checkinDate" id="checkinDate" class="datepicker"/></td>
<td><form:errors path="checkinDate" cssClass="error"/></td>
</tr>
<tr>
<td>
<p class="animated"><spring:message code="menu.bookingPage.checkoutDate" /></p>
</td>
<td><form:input cssClass="dropdownCss" path="checkoutDate" id="checkoutDate" class="datepicker"/></td>
<td><form:errors path="checkoutDate" cssClass="error"/></td>
</tr>
<tr>
<td>
<p class="animated"><spring:message code="menu.bookingPage.numberOfRooms" /></p>
</td>
<td><form:input cssClass="dropdownCss" path="numberOfRooms" id="numberOfRooms"/></td>
<td><form:errors path="numberOfRooms" cssClass="error"/></td>
</tr>
<tr>
<td>
<input type="submit" id="book" value='<spring:message code="menu.bookingPage.book" />' />
</td>
<td>
<a href="home"><spring:message code="menu.homePage.home" /></a>
</td>
</tr>
</table>
</form:form>
</div>
</div>
</div>
</div>
</body>
</html>