<?php 
 //Importing Database Script 
 require_once('db_connect.php');
 
    
 
 //$sql = "SELECT  `User_id`, `PName`, `pprice`, `paid` FROM `order_details` ";
 
 $sql = "SELECT SUM(pprice) FROM `order_details` WHERE paid='Paid'";
 
 //getting result 
 $result = mysqli_query($con,$sql);
 
 
 

 
 //creating a blank array 
 $result = array();
 
 //looping through all the records fetched
 while($row = mysqli_fetch_array($r)){
 
 "SUM(pprice)"=>$row['SUM(pprice)']
 
 
 }
 
 echo json_encode($result);
 
 
 
 mysqli_close($con);