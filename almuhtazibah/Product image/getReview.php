<?php 
 //Importing Database Script 
 require_once('db_connect.php');
 
 //Creating sql query
 $sql = "SELECT Review_id,customer_email,review_value,comment FROM review,sign_up WHERE review.User_id=sign_up.User_id";

 
 //getting result 
 $r = mysqli_query($con,$sql);
 
 //creating a blank array 
 $result = array();
 
 //looping through all the records fetched
 while($row = mysqli_fetch_array($r)){
 
 //Pushing name and id in the blank array created 
 array_push($result,array(
 "Review_id"=>$row['Review_id'],
 "customer_email"=>$row['customer_email'],
 "review_value"=>$row['review_value'],
 "comment"=>$row['comment'],
 ));
 }
 
 
 
 echo json_encode($result);
 
 
 
 mysqli_close($con);