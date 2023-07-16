let modal = document.querySelectorAll('.inicio');
modal.forEach(boton =>{
    boton.addEventListener('click', ()=>{
            // console.log(true)
                if(localStorage.getItem('_id')){
                    console.log(true)
            document.querySelector('.modal-logeado').classList.add('modal-show');
        }else{
            // boton.addEventListener('click', ()=>{
                document.querySelector('.modal').classList.add('modal-show');
            }
            })
        // })  
})

document.querySelector('#close').addEventListener('click', (e)=>{
    e.preventDefault();
    document.querySelector('.modal').classList.remove('modal-show');

})

document.querySelector('#close-logueado').addEventListener('click', (e)=>{
    e.preventDefault();
    document.querySelector('.modal-logeado').classList.remove('modal-show');

})

/*****************************************FORM FUNCTION********************************************** */

const form = document.querySelector('#form');
let btnLogin = document.querySelector('#btn-login');
const formRegistro = document.querySelector('#form-register');
const btnRegistro = document.querySelector('#register');
const btnIncio = document.querySelector('#login');
formRegistro.style.display='none';
btnIncio.style.display = 'none';

btnLogin.addEventListener('click', (e)=>{
    e.preventDefault();

    fetch("http://localhost:8080/EcommerceShoper/auth",{
        method: 'POST',
        headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        username: form.username.value,
        password: form.password.value
    })
    })
    .then(res=>res.json())
    .then(data=>{
        // console.log(data.usuario.name);
       if(data.results.error == null){
           // console.log('id', data.id);
            /*localStorage.setItem('_id', data.others._id);    
            console.log(data.accessToken);
            document.cookie = `token=${data.accessToken}`;*/
            //console.log(data)
            location.assign('/');
            // localStorage.setItem('user', data.usuario.name);
        }else{
            document.querySelector('#alerta').innerHTML = data.results.error
        }
    })

})

btnRegistro.addEventListener('click', ()=>{
    form.style.display = 'none';
    formRegistro.style.display = 'block';
    btnRegistro.style.display = 'none';
    btnIncio.style.display = 'block';

})

btnIncio.addEventListener('click', ()=>{
    form.style.display = 'block';
    formRegistro.style.display='none';
    btnIncio.style.display = 'none';
    btnRegistro.style.display = 'block';
});


let btnRegister = document.querySelector('#btn-register');



btnRegister.addEventListener('click', (e)=>{
    e.preventDefault();

    fetch("http://localhost:8080/user/register",{
        method: 'POST',
        headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        name: formRegistro.name.value,
        email: formRegistro.email.value,
        password: formRegistro.password.value
    })
    })
    .then(res=>res.json())
    .then(data=>{

        if(data.error = null){
        console.log(data)
        // console.log(data.usuario.name);
        }else{
            document.querySelector('#alerta').innerHTML = data.error
        }
    })

})