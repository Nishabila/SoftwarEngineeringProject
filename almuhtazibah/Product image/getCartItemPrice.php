<?php 
 //Importing Database Script 
 require_once('db_connect.php');
 
 //Creating sql query
 $sql = "SELECT price FROM  cart";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 
$count=mysqli_num_rows($r);
 //creating a blank array 
 $result = array();
 
 //looping through all the records fetched
 while($row = mysqli_fetch_array($r)){
 
 array_push($result,array(
 
 "price"=>$row['price'],
 
 ));
 }
 echo json_encode($result);
 
 mysqli_close($con);