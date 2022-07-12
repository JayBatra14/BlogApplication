********************************** ABOUT THE BLOG APP APPLICATION **********************************

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
STEP5: OPEN THE POSTMAN APP AND START USING THE APPLICATION

*************************** STEPS TO ACCESS THE BLOG APPLICATION API's IN POSTMAN ********************************

#API FOR USER REGISTRATION:
REQUEST METHOD: POST 
URL=> http://localhost:5000/api/v1/auth/register
JSON:
{
    "name":"User4",
    "email":"user4@dev.in",
    "password":"abcd",
    "about":"I am user4"
}

#API FOR USER LOGIN:
REQUEST METHOD: POST 
URL=> http://localhost:5000/api/v1/auth/login
***NOTE: username is your email
JSON:
{
    "username":"test@dev.in",
    "password":"abcd"
}

AFTER THIS AN TOKEN WILL BE GENERATED COPY THAT TOKEN AND USE THAT TO ACCESS OTHER API's

*** NOTE ALL THE GET API's ARE MADE PUBLIC AND FOR ACCESSING OTHER API's YOU HAVE TO PASS A PARAMETER IN THE HEADER SECTION WITH KEY AS AUTHORIZATION AND VALUE AS BEARER <TOKEN_GENERATED_ABOVE>
FOR EX:

AUTHORIZATION => For ex: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXRpbkBkZXYuaW4iLCJleHAiOjE2NTcyMjIzNzEsImlhdCI6MTY1NzIwNDM3MX0.N5-vG6auy8ak8WoNS40fYVLy30-NmP32yrjxxHwnjjMeDBeGA5STLVgIz3F8xez67Tdct5o5TuRwJlPycnJv

************************************* API's FOR USER *********************************

#API FOR GETTING ALL THE USERS
REQUEST METHOD: GET
URL=> http://localhost:5000/api/users/

#API FOR CREATING USER 
(NOTE: ALREADY DONE IN USER REGISTRATION)

#API FOR GETTING USER BY USER ID
REQUEST METHOD: GET
URL=> http://localhost:5000/api/users/{userId}
For ex: http://localhost:5000/api/users/1

#API FOR UPDATING USER BY USER ID
REQUEST METHOD: PUT
URL=> http://localhost:5000/api/users/{userId}
For ex: http://localhost:5000/api/users/1
JSON:
{
    "name":"User4",
    "email":"user4@dev.in",
    "password":"abcd",
    "about":"I am user4"
}

#API FOR DELETING USER BY USER ID (NOTE: ONLY ADMIN CAN DELETE A USER NORMAL USER CANNOT DELETE A USER)
REQUEST METHOD: DELETE
URL=> http://localhost:5000/api/users/{userId}
For ex: http://localhost:5000/api/users/1

************************************* API's FOR CATEGORY *********************************

#API FOR GETTING ALL CATEGORIES
REQUEST METHOD: GET
URL=> http://localhost:5000/api/categories/

#API FOR CREATING CATEGORY
REQUEST METHOD: POST 
URL=> http://localhost:5000/api/categories/
{
    "categoryTitle":"Programming Languages",
    "categoryDescription":"This category contains topics related to programming languages."
}

#API FOR GETTING CATEGORY BY CATEGORY ID
REQUEST METHOD: GET
URL=> http://localhost:5000/api/categories/{categoryId}
For ex: http://localhost:5000/api/categories/3

#API FOR UPDATING CATEGORY BY CATEGORY ID
REQUEST METHOD: PUT
URL=> http://localhost:5000/api/categories/{categoryId}
For ex: http://localhost:5000/api/categories/3
JSON:
{
    "categoryTitle":"Programming Languages with facts",
    "categoryDescription":"This category contains topics related to programming languages."
}

#API FOR DELETING CATEGORY BY CATEGORY ID
REQUEST METHOD: DELETE
URL=> http://localhost:5000/api/categories/{categoryId}
For ex: http://localhost:5000/api/categories/4

************************************* API's FOR POST *********************************

#API FOR GETTING ALL POSTS IN THE CATEGORY BY CATEGORY ID
REQUEST METHOD: GET
URL=> http://localhost:5000/api/category/{categoryId}/posts/
For ex: http://localhost:5000/api/category/1/posts/

***  NOTE : Use this API after you have uploaded a post image in uploadPostImage API and get the imageName from the O/P of that API
#API FOR GETTING THE IMAGE IN THE POST BY IMAGE NAME (NOTE: DON'T USE POSTMAN INSTEAD USE ANY BROWSER FOR THIS API)
REQUEST METHOD: GET
URL=> http://localhost:5000/api/post/image/{name of the image that you get in the output of upload image api}

#API FOR UPLOADING THE IMAGE IN THE POST BY POST ID
REQUEST METHOD: POST
IN THE BODY PASS KEY AS IMAGE SELECT THE FILE TYPE AS TEXT AND THEN UPLOAD THE IMAGE FROM YOUR SYSTEM
For ex: 
image => Name of the selected image will come here
URL=> http://localhost:5000/api/post/image/upload/{postId}
For ex: http://localhost:5000/api/post/image/upload/1

#API FOR GETTING ALL POSTS
REQUEST METHOD: GET
URL=> http://localhost:5000/api/posts/

#API FOR GETTING POST BY ID
REQUEST METHOD: GET
URL=> http://localhost:5000/api/posts/{postId}
For ex: http://localhost:5000/api/posts/1

#API FOR UPDATING POST BY POST ID
REQUEST METHOD: PUT
URL=> http://localhost:5000/api/posts/{postId}
For ex: http://localhost:5000/api/posts/1
JSON:
{
    "title":"Is Python best programming language?",
    "content":"yes, it is."
}

#API FOR DELETING POST BY POST ID
REQUEST METHOD: DELETE
URL=> http://localhost:5000/api/posts/{postId}
For ex: http://localhost:5000/api/posts/1

#API FOR GETTING ALL POSTS BY A GIVEN TITLE
REQUEST METHOD: GET
URL=> http://localhost:5000/api/posts/search/{Enter_The_Keyword}
For ex: http://localhost:5000/api/posts/search/post

#API FOR CREATING POST BY USER ID AND CATEGORY ID
REQUEST METHOD: POST 
URL=> http://localhost:5000/api/user/{userId}/category/{categoryId}/posts/
For ex: http://localhost:5000/api/user/1/category/2/posts/
JSON:
{
    "title":"This is post 3",
    "content":"This is Content of post 3"
}

#API FOR GETTING ALL POSTS DONE BY THE USER BY USER ID
REQUEST METHOD: GET
URL=> http://localhost:5000/api/user/{userId}/posts/
For ex: http://localhost:5000/api/user/1/posts/

************************************* API's FOR COMMENT *********************************

#API FOR DELETING COMMENT BY ID
REQUEST METHOD: DELETE 
URL=> http://localhost:5000/api/comments/{commentId}
For ex: http://localhost:5000/api/comments/1

#API FOR CREATING COMMENT
REQUEST METHOD: POST 
URL=> http://localhost:5000/api/post/{postId}/{userId}/comments
For ex: http://localhost:5000/api/post/2/1/comments
JSON:
{
    "content":"This is comment of post id 2 by user id 1"
}

