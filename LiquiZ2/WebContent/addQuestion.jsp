<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="org.adastraeducation.liquiz.*"%>
<%@ page import="org.adastraeducation.liquiz.util.*"%>

<!-- session problem for quiz!!! -->

<jsp:useBean id="quiz" class="org.adastraeducation.liquiz.Quiz" scope="session"/>

<%= request.getParameter("QuizContext")%>
<%System.out.println("in addQuestion.jpg");%>
Quiz now has: <%= request.getAttribute("NumberOfQuestions") %> 
questions in  <%= request.getAttribute("NumberOfQuestionContainers") %> question containers.
