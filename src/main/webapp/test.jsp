<%@page import="com.github.xuzw.html_layout.structure.YList"%>
<%@page import="com.github.xuzw.html_layout.structure.XList"%>
<%@page import="com.github.xuzw.forexroo.crm.view.CityView"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.github.xuzw.forexroo.entity.City"%>
<%@page import="com.github.xuzw.forexroo.crm.view.CityListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>test</title>
<%
    CityListView cityListView = new CityListView();
    City c1 = new City();
    c1.setName("London");
    c1.setDescriptions(new ArrayList<String>());
    c1.getDescriptions().add("London is the capital city of England.");
    c1.getDescriptions().add("It is the most populous city in the United Kingdom, with a metropolitan area of over 13 million inhabitants.");
    cityListView.add(c1);

    City c2 = new City();
    c2.setName("Paris");
    c2.setDescriptions(new ArrayList<String>());
    c2.getDescriptions().add("Paris is the capital and most populous city of France.");
    cityListView.add(c2);

    City c3 = new City();
    c3.setName("Tokyo");
    c3.setDescriptions(new ArrayList<String>());
    c3.getDescriptions().add("Tokyo is the capital of Japan, the center of the Greater Tokyo Area, and the most populous metropolitan area in the world.");
    cityListView.add(c3);
%>
<link rel="stylesheet" type="text/css" href="style/normalize.css" />
<%=XList.style.toString()%>
<%=YList.style.toString()%>
<%=CityView.style.toString()%>
</head>
<body>
	<%=cityListView.toHtmlString()%>
</body>
</html>