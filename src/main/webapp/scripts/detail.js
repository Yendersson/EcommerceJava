let imgP = document.querySelector(".imgPrincipalProducto");
let imgUno = document.querySelector(".imgSrc1");
let imgDos = document.querySelector(".imgSrc2");
let imgTres = document.querySelector(".imgSrc3");
let imgCuatro = document.querySelector(".imgSrc4");

// por medio del evento click intercambiamos el src de cada imagen 
// y de esa manera visulizar la imagen solicitada.

imgUno.addEventListener("click",
 function (){ 
  imgP.src = imgUno.src
})
imgDos.addEventListener("click",
 function (){ 
  imgP.src = imgDos.src
})
imgTres.addEventListener("click",
 function (){ 
  imgP.src = imgTres.src
})
imgCuatro.addEventListener("click",
 function (){ 
  imgP.src = imgCuatro.src
})
imgP.addEventListener("click",
 function (){ 
  imgP.src = imgUno.src
})

function addToKart(id){
	
	if (getCookie("products") != "0"){
		
		let cookie = getCookie("products") + id+"!";
		document.cookie = `products=${cookie};`;
		console.log("cookie", getCookie("products"));
	} else {
		document.cookie = `products=${id}!;`;
		console.log("cookie", getCookie("products"));	
	}
}

function getCookie(cname) {
  let name = cname + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(';');
  for(let i = 0; i <ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

const json = {"description": "DescripciÃ³n del producto",
					  "issuer_id":"1",
					  "installments": 1,
					  "payer": {
					    "email":"yendersoncolmenares67@gmail.com",
					    "identification": {"type":"DNI",
					    "number":"95790078"}
					  },
					  "payment_method_id": "debvisa",
					  "token": "49d962ed74331e582cdc9adb86358955",
					  "transaction_amount": 246354.15000000002
					}