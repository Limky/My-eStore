<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-wrapper">
   <div class="container">
      <h1>Add Product</h1>
      <p class="lead">Fill the below information to add a product:</p>
      
      <!-- addProduct.jsp 파일의 submit버튼을 눌렀을 때, post방식으로 AdminController.addProduct()메서드 호출  -->
      <sf:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct"
         method="post" modelAttribute="product">
         
         <div class="form-group">
            <label for="name">Name:</label>
            <sf:input path="name" id="name" class="form-control"/>
         </div>
         <div class="form-group">
            <label for="category">Category:</label>
            <sf:radiobutton path="category" id="category" value="컴퓨터"/>컴퓨터
            <sf:radiobutton path="category" id="category" value="가전"/>가전
            <sf:radiobutton path="category" id="category" value="신발"/>신발
         </div>
         <div class="form-group">
            <label for="description">Description:</label>
            <sf:input path="description" id="description" class="form-control"/>
         </div>
         <div class="form-group">
            <label for="price">Price:</label>
            <sf:input path="price" id="price" class="form-control"/>
         </div>
         <div class="form-group">
            <label for="unitInStock">Unit In Stock:</label>
            <sf:input path="unitInStock" id="unitInStock" class="form-control"/>      
         </div>
         <div class="form-group">
            <label for="manufacturer">Manufacturer:</label>
            <sf:input path="manufacturer" id="manufacturer" class="form-control"/>
         </div>
        
         <br>
         
         <!-- Post 방식의 addProduct Method 이용 -->
         <input type="submit" value="submit" class="btn btn-default">
         <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
         
      </sf:form>
      <br>
   </div>
</div>