<?php
 require_once('db_connect.php');
 



if(isset($_GET['add']))
   {
	  


 $product_name = $_POST['product_name'];
		$product_color = $_POST['product_color'];
		$product_price = $_POST['product_price'];
		$product_description = $_POST['product_description'];
	
    
			   
	   
	   if($_FILES['upload'])
	    {
			$on=$_FILES['upload']['name'];
			$sn=$_FILES['upload']['tmp_name'];			
			$dn="product_image/".$on;
			move_uploaded_file($sn,$dn);
			$sql ="INSERT INTO `product_details`(`product_name`, `product_color`, `product_price`, `product_description`, `Product_photo`)
             			VALUES ('$product_name','$product_color','$product_price','$product_description','$on')";
			
			$res=mysqli_query($con,$sql);
			
			if($res==true)
			echo "File Uploaded Successfully";
			else
			echo "Could not upload File";
			 
			
			 exit();
			 
		}

		
		
		mysqli_close($con);
   }
	