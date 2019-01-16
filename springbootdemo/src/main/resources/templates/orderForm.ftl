<!-- tag::allButValidation[] -->
<#import "spring.ftl" as spring/>  
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>Order Form</title>
    <link rel="stylesheet" href="/css/styles.css" />
  </head>

  <body>

    <form method="POST" action="/orders" >
      <h1>${userName},Order your taco creations!</h1>
		
      <img src="/images/TacoCloud.png"/>
      <a href="/design" id="another">Design another taco</a><br/>
      <div>  
  	  	<span><a href="/orders/current?l=zh_CN">中文</a></span>
      	<span><a href="/orders/current?l=en_US">英文</a></span>
      </div>  
		
		
      <div "#if fields.hasErrors()">
        <span class="validationError">
        Please correct the problems below and resubmit.
        </span>
      </div>

      <h3>Deliver my taco masterpieces to...</h3>
      <label><@spring.message "message.user.name"/>: </label>
      <input name="order.name" type="text" placeholder="<@spring.message "message.user.name"/>" field="${order}"/>
<!-- end::allButValidation[] -->
	  

      <input type="submit" value="Submit order"/>
    </form>

  </body>
</html>
<!-- end::allButValidation[] -->
