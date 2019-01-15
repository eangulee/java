<!-- tag::all[] -->
<!-- tag::head[] -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>Design</title>
    <link rel="stylesheet" th:href="@{/styles.css}" />
  </head>

  <body>
    <h1>Design your taco!</h1>
    <img th:src="@{/images/TacoCloud.png}"/>

<!-- tag::formTag[] -->
    <form method="POST" th:object="${design}">
    <!-- end::all[] -->

    <span class="validationError"
          th:if="${#fields.hasErrors('ingredients')}"
          th:errors="*{ingredients}">Ingredient Error</span>

    <!-- tag::all[] -->
    <div class="grid">
<!-- end::formTag[] -->
<!-- end::head[] -->
      <div class="ingredient-group" id="wraps">
<!-- tag::designateWrap[] -->
      <h3>Designate your wrap:</h3>
      <div th:each="ingredient : ${wrap}">
        <input name="ingredients" type="checkbox" th:value="${ingredient.id}" />
        <span th:text="${ingredient.name}">INGREDIENT</span><br/>
      </div>
<!-- end::designateWrap[] -->
      </div>

	  <div class="ingredient-group" id="proteins">
      <h3>Pick your protein:</h3>
      <div th:each="ingredient : ${protein}">
        <input name="ingredients" type="checkbox" th:value="${ingredient.id}" />
        <span th:text="${ingredient.name}">INGREDIENT</span><br/>
      </div>
      </div>

	  <div class="ingredient-group" id="cheeses">
      <h3>Choose your cheese:</h3>
      <div th:each="ingredient : ${cheese}">
        <input name="ingredients" type="checkbox" th:value="${ingredient.id}" />
        <span th:text="${ingredient.name}">INGREDIENT</span><br/>
      </div>
      </div>

	  <div class="ingredient-group" id="veggies">
      <h3>Determine your veggies:</h3>
      <div th:each="ingredient : ${veggies}">
        <input name="ingredients" type="checkbox" th:value="${ingredient.id}" />
        <span th:text="${ingredient.name}">INGREDIENT</span><br/>
      </div>
      </div>

	  <div class="ingredient-group" id="sauces">
      <h3>Select your sauce:</h3>
      <div th:each="ingredient : ${sauce}">
        <input name="ingredients" type="checkbox" th:value="${ingredient.id}" />
        <span th:text="${ingredient.name}">INGREDIENT</span><br/>
      </div>
      </div>
      </div>

      <div>


      <h3>Name your taco creation:</h3>
      <input type="text" th:field="*{name}"/>
      <!-- end::all[] -->
      <span th:text="${#fields.hasErrors('name')}">XXX</span>
      <span class="validationError"
            th:if="${#fields.hasErrors('name')}"
            th:errors="*{name}">Name Error</span>
      <!-- tag::all[] -->
      <br/>

      <button>Submit your taco</button>
      </div>
<!-- tag::closeFormTag[] -->
    </form>
<!-- end::closeFormTag[] -->
  </body>
</html>
<!-- end::all[] -->
