<?php 

	
	 require_once('db_connect.php');
	
	$sql = "SELECT * FROM product_details";
	
	
	//creating a query
	$query = $con->prepare("SELECT product_id, product_name,product_price,Product_photo FROM product_details;");
	
	//executing the query 
	$query->execute();
	
	//binding results to the query 
	$query->bind_result($id, $name,$product_price,$photo);
	
	$products = array(); 
	
	//traversing through all the result 
	while($query->fetch()){
		$row = array();
		$row['product_id'] = $id; 
		$row['product_name'] = $name;
		$row['product_price'] = $product_price; 
		 $row['Product_photo'] = $photo;
		array_push($products, $row);
	}
	
	//displaying the result in json format 
	echo json_encode($products);
	
	
	