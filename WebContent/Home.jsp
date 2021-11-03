<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name = "viewport" content = "width = device-width, initial-scale = 1">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        
      
         
         
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
		
		<link rel="stylesheet" href="slider/css/owl.carousel.min.css">
        <link rel="stylesheet" href="slider/css/owl.theme.default.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/4.5.6/css/ionicons.min.css">
		<link rel="stylesheet" href="slider/css/style.css">
          
    
    </head>
    
    <style>
			    
			    a.page-link.active{
				display:block;
			    background-color:#007bff;
			    color:#FFFFFF;
			}
    </style>
    <body>
       <jsp:include page="Menu.jsp"></jsp:include>
       
       <jsp:include page="slide.jsp"></jsp:include>
       <hr></hr>
       
  
        <!--end of menu-->
        <div class="container ">
        
        
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Category</a></li>
                            <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container ">
        
        
        
           
            
            <div class="row">
            
            
             
         <jsp:include page="Left.jsp"></jsp:include>

                <div class="col-sm-9">
                    <div id="content" class="row">
                        <c:forEach items="${listP}" var="o">
                            <div class="product col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${o.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id }" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${o.price} vnđ</p>
                                            </div>
                                            <div class="col">
                                                <a href="cart?id=${o.id }" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        
                 <div class="clearfix">
                    
                    <ul class="pagination">
                        <li class="page-item ${tag1 == 1?'disabled':''}"><a href="home?index=${tag1-1}" class="page-link" >Previous</a></li>
                        
                        <c:forEach begin ="1" end="${endP}" var ="i">
                        
                        
                        
                        	 <li class="page-item  ">	<a href="home?index=${i}"  class="page-link ${tag1 == i?'active':''}">${i}</a></li>
                        </c:forEach>
                        <li class="page-item ${tag1 == endP?'disabled':''}"><a href="home?index=${tag1+1}" class="page-link">Next</a></li>
                    </ul>
                </div>
                        
                        
                    </div>
                    
                    <div class="space">
                         <p></p>
                    </div>
                   
                    
        

            </div>
        </div>
        </div>

        <!-- Footer -->
       <jsp:include page="Footer.jsp"></jsp:include>
       
        
        
        

    
        
        
    </body>
</html>

