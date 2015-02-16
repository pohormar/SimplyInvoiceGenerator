 <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Simply Invoice Generator</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css"><!-- Styl odpowiedzialny za datepicker -->

<script src="js/jquery.js"></script> <!-- Na potrzeby datepicker -->
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script><!-- Na potrzeby datepicker -->
<script src="js/parsley.js"></script> <!-- Walidacacja pól -->


 <script>
 $(function() {
    $( "#invoice-date" ).datepicker();
  });
  </script>
</head>
<body>
	<div class="container padding-top">

		<div class="row header">
			<div class="col-md-12 column">
				<h1>Simply Invoice Generator</h1>
			</div>
		</div>


		<form action="InvoiceServlet" name="invoice-form" method="POST" id="form" data-parsley-validate>
			<div class="row space">
					<div class="col-md-6 column">
				
				
					<span class="padding-right">Numer Faktury:</span><input type="text"
						name="invoice-no" id="invoice-no" value="" class="input-width-51" data-parsley-required="true" readonly/>
				</div>
				<div class="col-md-6 column">
					<span class="padding-right">Data wystawienia:</span> <input
						type="text" class="input-width-40" data-parsley-required="true" placeholder="MM-DD-RRRR" name="invoice-date" id="invoice-date" />



				</div>
			</div>
<div class="space"></div>
<div class="space"></div>
<div class="space"></div>
			<div class="row">
				<div class="col-md-12 column space">
					<span class="padding-right section-title border-bottom">Dane
						sprzedawcy</span>
				</div>
			</div>
<div class="space"></div>
<div class="space"></div>

			<div class="row  style-4">
				<div class="col-md-2 column">
					<span class="padding-right">Nazwa firmy:</span>
				</div>
				<div class="col-md-10 column">
					<input type="text" class="input-width-100" name="seller-company-name" id="seller-company-name" data-parsley-required="true"/>
				</div>
			</div>
<div class="space"></div>
			<div class="row ">
				<div class="col-md-2 column">
					<span class="padding-right">Adres:</span>
				</div>
				<div class="col-md-10 column">
					<input type="text" class="input-width-80" name="seller-adress" data-parsley-required="true"/>
				</div>
			</div>

<div class="space"></div>
			<div class="row ">
				<div class="col-md-2 column">
					<span class="padding-right">Numer NIP:</span>
				</div>
				<div class="col-md-10 column">
					<input type="text" class="input-width-40" name="seller-nip" name="buyer-nip" data-parsley-type="digits" data-parsley-required="true" data-parsley-length="[10, 10]"/>
				</div>
			</div>


<div class="space"></div>
<div class="space"></div>
			<div class="row">
				<div class="col-md-12 column ">
					<span class="padding-right section-title border-bottom">Dane
						nabywcy</span>
				</div>
			</div>

<div class="space"></div>
			<div class="row">
				<div class="col-md-2 column">
					<span class="padding-right">Nazwa:</span>
				</div>
				<div class="col-md-10 column">
					<input type="text" class="input-width-100" name="buyer-name" data-parsley-required="true"/>
				</div>
			</div>
			
			<div class="space"></div>

			<div class="row">
				<div class="col-md-2 column">
					<span class="padding-right">Adres:</span>
				</div>
				<div class="col-md-10 column">
					<input type="text" class="input-width-80" name="buyer-adress" data-parsley-required="true"/>
				</div>
			</div>
			<div class="space"></div>


			<div class="row">
				<div class="col-md-2 column">
					<span class="padding-right">Numer NIP:</span>
				</div>
				<div class="col-md-10 column">
					<input type="text" class="input-width-40" name="buyer-nip" data-parsley-type="digits" data-parsley-required="true" data-parsley-length="[10, 10]"/>
				</div>
			</div>


<div class="space"></div>
			<div class="row">
				<div class="col-md-12 column ">
					<span class="padding-right section-title border-bottom">Szczegóły</span>
				</div>
			</div>

<div class="space"></div>
			<div class="row" >
				<div class="col-md-3 column">
					<span class="padding-right">Nazwa usługi/towaru:</span>
				</div>

				<div class="col-md-4 column">
					<input type="text" class="input-width-100" name="item-name" data-parsley-required="true"/>
				</div>
				<div class="col-md-1 column">
					<span class="padding-right">Ilość:</span>
				</div>
				<div class="col-md-3 column">
					<input type="text" class="input-width-80" name="item-quantity" data-parsley-type="digits" data-parsley-required="true"/>
				</div>

			</div>

<div class="space"></div>
			<div class="row">
				<div class="col-md-3 column">
					<span class="padding-right">Cena jednostkowa:</span>
				</div>

				<div class="col-md-3 column">
					<input type="text" name="item-price" data-parsley-required="true" data-parsley-type="number"/>
				</div>

				<div class="col-md-2 column">
					<span class="padding-right" >Stawka VAT:</span>
				</div>
				<div class="col-md-4 column">
					<select name="item-vat" data-parsley-required="true">
<option value="">>Wybierz</option>
						<option value="23">23%</option>
						<option value="8">8%</option>
						<option value="7">7%</option>
						<option value="5">5%</option>
						<option value="4">4%</option>
						<option value="0">0%</option>
					</select>
				</div>


</div>
<div class="space"></div>
			<div class="row ">	<div class="space"></div>	
				<div class="col-md-9 column">	<div class="space"></div>	</div>
				<div class="col-md-3 column">
					<input type="submit" onClick="przetwarzaj_dane()"  value="Zapisz" />
							</div>
					
			</div>	<div class="space"></div>	

		</form>	<div class="space"></div>	
	</div>
		<script src="js/parsley-create.js"></script>
 <script type="text/javascript" language="javascript"> 
var d = new Date();
function f(n) { return n < 10 ? '0' + n : n; }  
var random_num = Math.floor(Math.random() * (99999999999 -  10000000000)) + 10000000000;
random_num = "FW/" + d.getFullYear() + f(d.getMonth()+1) + f(d.getDate()) + "/" + d.getHours() + d.getMinutes() + d.getSeconds() + d.getMilliseconds();
document.getElementsByName("invoice-no")[0].value = random_num;
</script>

</body>
</html>