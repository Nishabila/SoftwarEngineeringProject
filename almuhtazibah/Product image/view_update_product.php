<?php 
 //Importing Database Script 
 require_once('db_connect.php');
 
    
  //---FOR BANGLA INSERT-----
 
 mysqli_query($con,'SET CHARACTER SET utf8'); 
 mysqli_query($con,"SET SESSION collation_connection ='utf8_general_ci'");
 
 //----------
 
 //Creating sql query
 $sql = "SELECT  `product_name`, `product_color`, `product_price`, `product_description`, `Product_photo` FROM `product_details` ";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 
 //creating a blank array 
 $result = array();
 
 //looping through all the records fetched
 while($row = mysqli_fetch_array($r)){
 
 //Pushing name and id in the blank array created 
 array_push($result,array(
 "product_name"=>$row['product_name'],
 "product_color"=>$row['product_color'],
 "product_price"=>$row['product_price'],
 "product_description"=>$row['product_description'],
 "Product_photo"=>$row['Product_photo']
 ));
 
 
 }
 
 echo json_encode($result);
 
 
 
 mysqli_close($con);