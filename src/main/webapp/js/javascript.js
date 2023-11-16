function add_to_cart(pid,pname,price,quantity)
{
let cart= localStorage.getItem("cart");
if(cart == null)
{
//When cart array that we have created is null means none of the product has been added yet by the user.
let products=[];
let product={productId:pid,productName:pname,productQuantity:1,productPrice:price}
products.push(product);
localStorage.setItem("cart",JSON.stringify(products));
//console.log("product is added for the first time..")
showToast("Item is added to the cart...")

}
else
{
//when cart already contains some of the products
let pcart=JSON.parse(cart);
let oldProduct= pcart.find((item)=> item.productId==pid)
if(oldProduct)
{

//when user is trying to add the same product which is already add to cart earlier
//simply increasing the quantity value by no. of hits
oldProduct.productQuantity=oldProduct.productQuantity +1
if(oldProduct.productQuantity<quantity)
{
pcart.map((item)=>{
if(item.productId == oldProduct.productId)
{
item.productQuantity=oldProduct.productQuantity;
}
})
localStorage.setItem("cart",JSON.stringify(pcart));
console.log("Product quantity is increased")
showToast(oldProduct.productName+" Product Quantity is increased")

}
else
{
console.log("Product does not exist more!!!")}
}
else
{
//when new product is to be added to the cart
let product={productId:pid, productName:pname, productQuantity:1, productPrice: price}
pcart.push(product);
localStorage.setItem("cart",JSON.stringify(pcart));
console.log("Product quantity is added...")
showToast("Product is added to cart..")


updateCart();
}
}

//update cart

}
function updateCart(){
let cartString=localStorage.getItem("cart");
let cart= JSON.parse(cartString);
if(cart==null || cart.length==0)
{
console.log("cart is empty...")
$(".cart-items").html("(0)");
$(".cart-body").html("<h3>Cart does not have any item</h3>");
$(".checkout-btn").addClass('disabled');

}
else
{
//there is something to show
console.log(cart)
$(".cart-items").html(`(${cart.length})`);
let table = `
  <table class='table'>
    <thead class='thead-light'>
      <tr>
        <th>Item Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total Price</th>
        <th>Action</th>
      </tr>
    </thead>
`;

let totalPrice = 0;

cart.map((item) => {
  table += `
    <tr>
      <td>${item.productName}</td>
      <td>${item.productPrice}</td>
      <td>${item.productQuantity}</td>
      <td>${item.productQuantity * item.productPrice}</td>
      <td><button onclick='deleteItemFromCart(${item.productId})' class='btn btn-danger btn-sm btn-remove'>remove</button></td>
    </tr>`;

  totalPrice += item.productPrice * item.productQuantity;
});

table += `
    <tr>
      <td colspan='5' class='text-right font-weight-bold m-5'>Total Price: ${totalPrice}</td>
    </tr>
  </table>`;

// Now 'table' variable contains the dynamically generated HTML
  $(".cart-body").html(table);

}
}
function deleteItemFromCart(pid)
{
let cart=JSON.parse(localStorage.getItem('cart'));
let newCart=cart.filter(item=> item.productId!=pid)
localStorage.setItem('cart',JSON.stringify(new cart))
updateCart();

}
$(document).ready(function () {
updateCart();
showToast("Item is removed from the cart...")

}
)

function showToast(content) {
 $("#toast").addClass("display");
 $("#toast").html(content);
 setTimeout{()=>{
 $("#toast").removeClass("display");

 },2000);
 }

 // Adjust the time (in milliseconds) the toast should be visible
}
