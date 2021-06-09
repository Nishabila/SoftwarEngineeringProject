<?php 
 //Importing Database Script 
 require_once('db_connect.php');
 
 //Creating sql query
 $sql = "SELECT * FROM sign_up";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 
 //creating a blank array 
 $result = array();
 
 //looping through all the records fetched
 while($row = mysqli_fetch_array($r)){
 
 //Pushing name and id in the blank array created 
 array_push($result,array(
 "User_id"=>$row['User_id'],
 "Full_name"=>$row['Full_name'],
 "customer_email"=>$row['customer_email'],
 "Mobile_no"=>$row['Mobile_no'],
 
 ));
 }
 
 
 
 echo json_encode($result);
 
 
 
 mysqli_close($con);