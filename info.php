
<html>
   <head>
      <title>Connecting MySQL Server</title>
      <link rel="stylesheet" href="bootstrap.min.css">        <!--Linking to Bootstrap Classes For Designing purpose -->
      <meta name="viewport" content="width=device-width, initial-scale=1">    <!--Linking to Bootstrap Classes For Designing purpose-->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  <!--Linking to Bootstrap Classes For Designing purpose -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>  <!--Linking to Bootstrap Classes For Designing purpose-->
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>     <!--Linking to Bootstrap Classes For Designing purpose -->
   </head>
   <body>
      <?php
          // Code for Connection with Mysql

         $dbhost = 'localhost';   //Remote IP of Mysql      
         $dbuser = 'root';                 //User id for Connection
         $dbpass = '';               //Password For User id 
         $conn = mysql_connect($dbhost, $dbuser, $dbpass);  //Establishing Connection

         //Checking For Connection is Establish or Not
         if(! $conn ) 
         {
            die('Could not connect: ' . mysql_error());   //if not then Print error using Mysql Error
         }
         else
         {
         echo 'Connected successfully<br><br><br><br><br>';  //if Establish then print message sucessfully 
         }  


         mysql_select_db("test");  // Selecting database for Operations
         ?>

<!--**************************************************************************************************************************************-->
      <!-- HTML form for taking inputs from user.Design using BOOTSTRAP -->   
      <div class="container">
         <div class="row">
            <div class="col-sm-4">
               <form role="form" name="" method="POST" action="info.php">
                  <div class="form-group">
                     <input class="form-control"  placeholder="ID" name="id" type="text" autofocus required>
                  </div>
                  <div class="form-group">
                     <input class="form-control" placeholder="Name" name="name" type="text" value="" required>
                  </div>
                  <input type="submit" name="submit" class="btn btn-success" value="insert">
               </form>

            </div>
            <div class="col-sm-4">
               <form name="delete" method="POST" action="info.php">
                  <div class="form-group">
                     <input class="form-control"  placeholder="ID" name="id" type="text" autofocus required>
                  </div>
                <br><br><br>
                  <input type="submit" name="delete" class="btn btn-danger" value="DELETE">
               </form>
            </div>
         </div>
      </div>  
<!--**************************************************************************************************************************************-->

<!--**************************************************************************************************************************************-->

      
      <?php

      //if Submit Button is Pressed Then the following code will be executed

         if (isset($_POST["submit"]))
         {
               $a=$_POST['id'];
               $b=$_POST['name'];
              
               //Query for inserting data into database

               $res=mysql_query("INSERT INTO stud(id,name) values ('$a','$b') ");
               
               //Checking for Query is fire or not+
               if($res)
               {
                     ?>
                     <script>
                        alert("Inserted Sucessfully"); //if fire then give alert
                     </script>
                     <?php
               }
         }
         

         if (isset($_POST["delete"]))
         {
               $a=$_POST['id'];
               //Query for inserting data into database

               $res=mysql_query("DELETE FROM stud WHERE id=$a ");
            
               //Checking for Query is fire or not
               if($res)
               {
                     ?>
                     <script>
                        alert("Deleted Sucessfully"); //if fire then give alert
                     </script>
                     <?php
               }
         }
         
      ?>
<!--**************************************************************************************************************************************-->



<!--**************************************************************************************************************************************-->

      <?php 

         //Query for Retrieving the data

         $result = mysql_query("SELECT * from stud");
         
         //Checking for Query is fire or not
         if(!$result)
         {
          echo "Query not Fired";//if fire then give message
         }
         else
         {
          echo "Query Fired";//if fire then give alert
         }
         // Variable $result contains all the data which is retrive from query.now the following code is written only for displying the data in well manner

         ?>
            

      <!--Again bootstrap comes here.i used inbuild boostrap classes for designing.Dont confued with that  -->      
      <br>
      <h1> Student Data </h1>
      <div class="table-responsive">
      <table class="table col-sm-4">
         <tr>
            <td>ID</td>
            <td>Name</td>
         </tr>
                  <?php
                     while ($row = mysql_fetch_array($result)) //Fetching data one by one from variable $result
                        { 
                              ?>
                              <tr>
                                 <td><?php echo $row{'id'}; ?></td>
                                 <td><?php echo $row{'name'}; ?></td>
                              </tr>
                              <?php
                        }
                     mysql_close($conn);
                     ?>
      </table>
   </body>
</html>