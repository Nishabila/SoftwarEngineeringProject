

<?php 
 //Importing Database Script 
 require_once('db_connect.php');
 
 //Creating sql query
 $sql = "SELECT Order_id,PName,pprice,pcolor,plength,psize,proof_detail,customer_email,Delivery_method,Description FROM sign_up NATURAL JOIN order_details NATURAL JOIN payment_system NATURAL JOIN delivery_system";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 
 //creating a blank array 
 $result = array();
 
 //looping through all the records fetched
 while($row = mysqli_fetch_array($r)){
 
 //Pushing name and id in the blank array created 
 array_push($result,array(
 "Order_id"=>$row['Order_id'],
 "PName"=>$row['PName'],
 "pprice"=>$row['pprice'],
 "pcolor"=>$row['pcolor'],
 "plength"=>$row['plength'],
  "psize"=>$row['psize'],
 "proof_detail"=>$row['proof_detail'],
 "customer_email"=>$row['customer_email'],
 "Delivery_method"=>$row['Delivery_method'],
 "Description"=>$row['Description'],
 
 ));
 }
 
 
 
 echo json_encode($result);
 
 
 
 mysqli_close($con);