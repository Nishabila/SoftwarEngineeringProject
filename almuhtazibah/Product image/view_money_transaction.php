<?php 
 //Importing Database Script 
 require_once('db_connect.php');
 
    
  //---FOR BANGLA INSERT-----
 
 mysqli_query($con,'SET CHARACTER SET utf8'); 
 mysqli_query($con,"SET SESSION collation_connection ='utf8_general_ci'");
 
 //----------
 
 //Creating sql query
 //$sql = "SELECT * FROM customer";
 
 $sql = "SELECT `Order_id`, `User_id`, `PName`, `pprice`, `paid` FROM `order_details`  ";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 
 //creating a blank array 
 $result = array();
 
 //looping through all the records fetched
 while($row = mysqli_fetch_array($r)){
 
 //Pushing name and id in the blank array created 

 //  for  all data
 

 //Pushing name and id in the blank array created 
 array_push($result,array(
     
     "Order_id"=>$row['Order_id'],
 "User_id"=>$row['User_id'],
 "PName"=>$row['PName'],
 "pprice"=>$row['pprice'],
 "paid"=>$row['paid']
 
 ));
 
 
 
 }
 
 echo json_encode($result);
 
 
 
 mysqli_close($con);