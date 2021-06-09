<?php 
 if($_SERVER['REQUEST_METHOD']=='POST'){
 //Getting values 
 //Getting values
 $paid = $_POST['paid'];
 $Order_id = $_POST['Order_id'];

 //importing database connection script 
 require_once('db_connect.php');
 
 //Creating sql query 
 

 
 $sql = "UPDATE `order_details`  SET `paid` ='$paid'  WHERE `Order_id` = '$Order_id'";
 
 
  
 //Updating database table 
 if(mysqli_query($con,$sql)){
echo "Success";


 }else{
 echo 'Could Not Update  Try Again';
 }
 
 //closing connection 
 mysqli_close($con);
 }