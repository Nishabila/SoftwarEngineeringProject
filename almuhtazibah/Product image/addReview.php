<?php 

 $customer_email = $_POST['customer_email'];
$comment = $_POST['comment'];
 $review_value = $_POST['review_value'];
 require_once('db_connect.php');
 
  
 $sql = "SELECT User_id FROM  sign_up WHERE customer_email= '$customer_email'";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 
 $count=mysqli_num_rows($r);


if($count>0){
 while ($row = $r->fetch_assoc()) {
  $ud = $row["User_id"];
}
  
 //Creating an sql query
 $sql_2 = "INSERT INTO review(User_id,review_value,comment) VALUES ('$ud','$review_value','$comment')";
  
 //Executing query to database
 if(mysqli_query($con,$sql_2)){
    
  echo 'Review Added Successfully';

 }else{
 echo 'Could Not Add Review';
 }
}
else
 echo 'wrong email';
 //Closing the database 
 mysqli_close($con);
 

