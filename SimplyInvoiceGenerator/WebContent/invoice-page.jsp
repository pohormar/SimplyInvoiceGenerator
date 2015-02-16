 <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simply Invoice Generator</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>

<div class="container padding-top">

<div class="row header">
<div class="col-md-12 column"> <h1>Simply Invoice Generator</h1></div>
		</div>
	

	
	<div class="row ">
	<div class="space"></div>
	<div class="space"></div>
	<div class="space"></div>
		<div class="col-md-12 column center no-print"> <span class="padding-right section-title">Faktura została poprawnie dodana do bazy danych.</span>
		<div class="space"></div>
		<div class="space"></div>
		</div>
</div>
<div class="row "></div>
	<div class="space"></div>
<div class="row ">
		<div class="col-md-6 column"> <span class="padding-left section-title">Numer faktury: </span>${requestScope.invoices.invoiceNo} 
		</div>
		<div class="col-md-6 column"> <span class="padding-left section-title">Data: </span>${requestScope.invoices.invoiceDate} 
		</div>
</div>
<div class="space"></div>
<div class="space"></div>
<div class="row "></div>

<div class="row ">
<div class="col-md-6 column">

<div class="col-md-12 column   ">
<div class="space"></div>
<span class="bold border-bottom">Dane Sprzedawcy </span>
</div>
<div class="space"></div>
<div class="col-md-12 column  ">
<div class="space"></div>
<span class="bold">Nazwa Firmy: </span>${requestScope.seller.sellerCompanyName} 
</div>
<div class="col-md-12 column ">
<div class="space"></div>
<span class="bold">Adres: </span>${requestScope.seller.sellerAdress} 
</div>

<div class="col-md-12 column ">
<div class="space"></div>
<span class="bold">Numer NIP: </span>${requestScope.seller.sellerNip} 
</div>
</div>


<div class="col-md-6 column">
<div class="col-md-12 column   ">
<div class="space"></div>
<span class="bold border-bottom">Dane Nabywcy </span>
</div>

<div class="col-md-12 column  ">
<div class="space"></div>
<span class="bold">Nazwa: </span>${requestScope.buyer.buyerName} 
</div>

<div class="col-md-12 column ">
<div class="space"></div>
<span class="bold">Adres: </span>${requestScope.buyer.buyerAdress} 
</div>

<div class="col-md-12 column ">
<div class="space"></div>
<span class="bold">Numer NIP: </span>${requestScope.buyer.buyerNip} 
</div>

</div>

</div>

<div class="row ">
<div class="col-md-12 column ">
<div class="space"></div>
<div class="space"></div>

<table>
<tr><th>Nazwa usługi / towaru</th><th>Ilość</th><th>Cena jednostkowa</th><th>Stawka VAT</th><th>Wartość brutto</th></tr>
<tr><td>${requestScope.item.itemName} </td><td>${requestScope.item.itemQuantity} </td><td>${requestScope.item.itemPrice}</td><td>${requestScope.item.itemVat}</td><td>${requestScope.invoices.priceBrutto}</td></tr>
</table>
<div class="space"></div>
<div class="space"></div>
</div>
</div>
<div class="space"></div>
<div class="row no-print">
	<div class="col-md-6 "><button type="button" onClick="window.print()">Drukuj fakturę</button> </div>
		<div class="col-md-6 ">  <a href="index.jsp">  <button type="button">Wystaw nową fakturę </button> </a>
	<div class="space"></div></div>



</div></div>

	


</body>
</html>