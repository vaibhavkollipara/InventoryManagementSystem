# InventoryManagementSystem
Inventory Management System for tracking within physical, single site warehouses(Project to demonstrate multi-threading in java).

<h3>Description</h3>
IMS will be responsible for the inventory tracking within physical, single site warehouses. IMS will track the named physical location of a product within the warehouse and the inventory level of each product. IMS will be deployed to busy warehouses supporting many pickers and restockers working with individual terminals and clients. Updates to inventory levels will be handled in real time to prevent pickers trying to pick a product that is out of stock.

<h4>Assumptions</h4>
<ul>
  <li>Each product will be stored at one and only one named location within the warehouse.</li>
  <li>Inventory adjustments may be additive (restocks) or subtractive (picks).</li>
  <li>No additional product information needs to be tracked beyond location and level.</li>
</ul>

<h4>Project Developement Environment Details</h4>
<ul>
  <li>Operaitng System : Windows 10</li>
  <li>Programming Language : Java</li>
  <li>IDE : Eclipse</li>
</ul>

<h4>Sample Output</h4>
<span>
Terminal 5 pick(B,1) :
Failed: Products with productId B are out of Stock

Terminal 4 pick(C,5) :
Failed: Products with productId C are out of Stock

Terminal 2 pick(C,2) :
Failed: Products with productId C are out of Stock

Terminal 1 restock(A,4) :
LocationA has 4 products with productId A

Terminal 3 restock(B,3) :
LocationB has 3 products with productId B

Terminal 5 restock(B,4) :
LocationB has 7 products with productId B

Terminal 4 pick(A,4) :
Successful: 4 products with productId A can be picked from LocationA

Terminal 2 restock(B,5) :
LocationB has 12 products with productId B

Terminal 1 pick(C,5) :
Failed: Products with productId C are out of Stock

Terminal 3 restock(B,4) :
LocationB has 16 products with productId B

Terminal 5 pick(B,4) :
Successful: 4 products with productId B can be picked from LocationB

Terminal 4 restock(C,4) :
LocationC has 6 products with productId C

Terminal 2 restock(C,2) :
LocationC has 2 products with productId C

Terminal 1 restock(A,3) :
LocationA has 3 products with productId A

Terminal 3 restock(B,1) :
LocationB has 13 products with productId B

Terminal 5 restock(B,1) :
LocationB has 14 products with productId B

Terminal 2 restock(B,5) :
LocationB has 19 products with productId B

Terminal 4 restock(B,4) :
LocationB has 23 products with productId B

Terminal 3 restock(A,2) :
LocationA has 7 products with productId A

Terminal 1 restock(A,2) :
LocationA has 5 products with productId A

Terminal 2 restock(C,2) :
LocationC has 8 products with productId C

Terminal 4 pick(C,5) :
Successful: 5 products with productId C can be picked from LocationC

Terminal 5 restock(A,2) :
LocationA has 9 products with productId A

Terminal 3 restock(C,2) :
LocationC has 5 products with productId C

Terminal 1 restock(A,2) :
LocationA has 11 products with productId A
</span>
