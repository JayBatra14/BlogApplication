********************************** ABOUT THE BLOG APP APPLICATION **********************************

TO ACCESS MY APPLICATION USE THE BELOW URL:
URL=> http://ec2-54-172-45-97.compute-1.amazonaws.com/swagger-ui/index.html#/

* This app is created for the users so that they can register in out app and interact with other users.
* The users can create categories create posts and can also comment on other user's post
* They can get the details of all the users, categories, posts and comments written by them.
* They can also delete the categories, posts and comments.
* Only the Admin user can delete the user from the application.

********************* STEPS TO USE THIS APPLICATION IN YOUR LOCAL SYSTEM ****************************

STEP1: DOWNLOAD THE ZIP FILE FROM THE REPOSITORY BY CLICKING ON CODE BUTTON
STEP2: UNZIP THE DOWNLOADED FILE AND THEN IMPORT THE APPLICATION IN YOUR PREFERRED IDE 
STEP3: CREATE A DATABASE IN MYSQL WITH NAME AS blog_app_apis
STEP4: RUN THE PROJECT AS SPRING BOOT APP OR JAVA APPLICATION
STEP5: ENTER THE URL http://localhost:5000/swagger-ui/index.html IN THE BROWSER

******************************** STEPS TO ACCESS THE BLOG APPLICATION API's IN SWAGGER ********************************

*** NOTE: YOU CAN ACCESS ALL THE GET REQUESTS WITHOUT LOGGING IN
*** IF YOU WANT TO USE POSTMAN THEN OPEN Postman_Readme.txt FOR THE STEPS

1. auth-controller => Auth Controller

#API FOR USER REGISTRATION:
Step1: Go to auth-controller
Step2: Go to /api/v1/auth/register => registerUser API
Step3: Click on try it out
Step4: Enter the values in the Edit Value box

For user registration in JSON pass only about, email, name, and  password and remove everything else from JSON
For ex:

{
  "about": "I am a programmer",
  "email": "your_email@dev.in",
  "name": "your_name",
  "password": "your_password"
}

Step5: Click on execute button below
Step6: Scroll down for seeing the O/P in the response body section

#API FOR USER LOGIN:
Step1: Go to auth-controller
Step2: Go to /api/v1/auth/login => createToken API
step3: Click on try it out
Step4: Enter the values in the Edit Value box

For user login in JSON pass password and username (i.e. your email) 
For ex:

{
  "password": "your_password",
  "username": "your_email@dev.in"
}

Step5: Click on execute button below
Step6: Scroll down for seeing the O/P in the response body section

O/P => It will generate a token for you copy that token after that go above you will see an authorize button click on that then in the Value field enter the value as "Bearer <Token that you copied>"

For ex: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXRpbkBkZXYuaW4iLCJleHAiOjE2NTcyMjIzNzEsImlhdCI6MTY1NzIwNDM3MX0.N5-vG6auy8ak8WoNS40fYVLy30-NmP32yrjxxHwnjjMeDBeGA5STLVgIz3F8xez67Tdct5o5TuRwJlPycnJv


***************** NOW AFTER SUCCESSFULL LOGIN YOU CAN ACCESS THE BLOG APPLICATION API's *****************************

2. category-controller => Category Controller

#API FOR GETTING ALL CATEGORIES
Step1: Go to /api/categories/ => getCategories
Step2: Click on try it out
Step3: Click on execute button below
Step4: Scroll down for seeing the O/P in the response body section

#API FOR CREATING CATEGORY
Step1: Go to /api/categories/ => createCategory
Step2: Click on try it out
Step3: Enter the values in the Edit Value box

For creating category in JSON pass only categoryDescription and categoryTitle and remove everything else from JSON
For ex:

{
  "categoryDescription": "Give the description",
  "categoryTitle": "Give the title"
}

Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

#API FOR GETTING CATEGORY BY CATEGORY ID
Step1: Go to /api/categories/{categoryId} => getCategory
Step2: Click on try it out
Step3: Enter the categoryId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

#API FOR UPDATING CATEGORY BY CATEGORY ID
Step1: Go to /api/categories/{categoryId} => updateCategory
Step2: Click on try it out

For updating category in JSON pass only categoryDescription and categoryTitle and remove everything else from JSON
For ex:

{
  "categoryDescription": "Give the description",
  "categoryTitle": "Give the title"
}

Step3: Enter the categoryId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

#API FOR DELETING CATEGORY BY CATEGORY ID
Step1: Go to /api/categories/{categoryId} => deleteCategory
Step2: Click on try it out
Step3: Enter the categoryId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

3. comment-controller => Comment Controller

#API FOR DELETING COMMENT BY ID
Step1: Go to /api/comments/{commentId} => deleteComment
Step2: Click on try it out
Step3: Enter the commentId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

#API FOR CREATING COMMENT
Step1: Go to /api/post/{postId}/{userId}/comments => createComment
Step2: Click on try it out
Step3: Enter the values in the Edit Value box

For creating comment in JSON pass only content and remove everything else from JSON
For ex:

{
  "content": "Give the content of the comment"
}

Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

4. post-controller => Post Controller

#API FOR GETTING ALL POSTS IN THE CATEGORY BY CATEGORY ID
Step1: Go to /api/category/{categoryId}/posts/ => getPostsByCategory
Step2: Click on try it out
Step3: Enter the categoryId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

***NOTE : Use this API after you have uploaded a post image in uploadPostImage API and get the imageName from the O/P of that API
#API FOR GETTING THE IMAGE IN THE POST BY IMAGE NAME
*** THIS CAN BE USED WHEN FRONT END IS COMPLETED

#API FOR UPLOADING THE IMAGE IN THE POST BY POST ID
*** THIS CAN BE USED WHEN FRONT END IS COMPLETED

#API FOR GETTING ALL POSTS
Step1: Go to /api/posts/=> getAllPosts
Step2: Click on try it out
Step3: Click on execute button below
Step4: Scroll down for seeing the O/P in the response body section

#API FOR GETTING POST BY ID
Step1: Go to /api/posts/{postId} => getPost
Step2: Click on try it out
Step3: Enter the postId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

#API FOR UPDATING POST BY POST ID
Step1: Go to /api/posts/{postId} => updatePost
Step2: Click on try it out

For creating post in JSON pass only content and title and remove everything else from JSON
For ex:
{
  "content": "Enter the content",
  "title": "Enter the title",
}

Step3: Enter the postId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

#API FOR DELETING POST BY POST ID
Step1: Go to /api/posts/{postId} => deletePost
Step2: Click on try it out
Step3: Enter the userId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

#API FOR GETTING ALL POSTS BY A GIVEN TITLE
Step1: Go to /api/posts/search/{keywords} => searchPostByTitle
Step2: Click on try it out
Step3: Enter the keywords (i.e title with which you want to search the posts) in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

#API FOR CREATING POST BY USER ID AND CATEGORY ID
Step1: Go to /api/user/{userId}/category/{categoryId}/posts/ => createPost
Step2: Click on try it out
Step3: Enter the categoryId in the input box

For creating post in JSON pass only content and title and remove everything else from JSON
For ex:
{
  "content": "Enter the content",
  "title": "Enter the title",
}

Step4: Enter the userId in the input box
Step5: Click on execute button below
Step6: Scroll down for seeing the O/P in the response body section

#API FOR GETTING ALL POSTS DONE BY THE USER BY USER ID
Step1: Go to /api/user/{userId}/posts/ => getPostsByUser
Step2: Click on try it out
Step3: Enter the userId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

5. user-controller => User Controller

#API FOR GETTING ALL THE USERS
Step1: Go to /api/users/ => getAllUsers
Step2: Click on try it out
Step3: Click on execute button below
Step4: Scroll down for seeing the O/P in the response body section

#API FOR CREATING USER 
(NOTE: ALREADY DONE IN USER REGISTRATION)

#API FOR GETTING USER BY USER ID
Step1: Go to /api/users/{userId} => getUser
Step2: Click on try it out
Step3: Enter the userId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

#API FOR UPDATING USER BY USER ID
Step1: Go to /api/users/{userId} => updateUser
Step2: Click on try it out


For ex:

{
  "about": "I am a programmer",
  "email": "your_email@dev.in",
  "name": "your_name",
  "password": "your_password"
}

Step3: Enter the userId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section

#API FOR DELETING USER BY USER ID (NOTE: ONLY ADMIN CAN DELETE A USER NORMAL USER CANNOT DELETE A USER)
Step1: Go to /api/users/{userId} => deleteUser
Step2: Click on try it out
Step3: Enter the userId in the input box
Step4: Click on execute button below
Step5: Scroll down for seeing the O/P in the response body section
