<?php 
 //Importing Database Script 
 require_once('db_connect.php');
 
 //Creating sql query
 $sql = "SELECT * FROM cart";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 
 //creating a blank array 
 $result = array();
 
 //looping through all the records fetched
 while($row = mysqli_fetch_array($r)){
 
 //Pushing name and id in the blank array created 
 array_push($result,array(
 "cart_id"=>$row['cart_id'],
 "product_id"=>$row['product_id'],
 "product_name"=>$row['product_name'],
"price"=>$row['price'],
 "size"=>$row['size'],
 "length"=>$row['length'],
"color"=>$row['color'],

 
 ));
 }
 
 
 
 echo json_encode($result);
 
 
 
 mysqli_close($con);