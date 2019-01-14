<!-- tag::allButValidation[] -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>Taco Cloud</title>
    <link rel="stylesheet" href="/css/styles.css" />
  </head>

  <body>

    <form method="POST" action="/orders" >
      <h1>${userName},Order your taco creations!</h1>
		
      <img src="/images/TacoCloud.png"/>
      <a href="/design" id="another">Design another taco</a><br/>
		
      <div "#if fields.hasErrors()">
        <span class="validationError">
        Please correct the problems below and resubmit.
        </span>
      </div>

      <h3>Deliver my taco masterpieces to...</h3>
      <label>Name: </label>
      <input name="order.name" type="text" field="${order}"/>
<!-- end::allButValidation[] -->
	  

      <input type="submit" value="Submit order"/>
    </form>

  </body>
</html>
<!-- end::allButValidation[] -->
