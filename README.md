This repository contains the backend code for a Maker-Product management system. The system is designed to manage two main entities: Makers and Products. Each Maker can have multiple associated Products, and there is a strong relationship between Makers and Products, meaning that a Product must be associated with a Maker.

Database Structure
The database consists of two main tables:

Makers Table:
Fields: id, name, email, img

Products Table:
Fields: id, name, price, maker_id (foreign key to Makers table)
Endpoints

The API provides various endpoints to perform CRUD (Create, Read, Update, Delete) operations on Makers and Products.

Makers Endpoints:
GET /maker/findAll: Get all Makers.
GET /maker/findById/{id}: Get a Maker by ID.
GET /maker/findByName/{name}: Get a Maker by name.
POST /maker/save: Add a new Maker.
PUT /maker/update/{id}: Update a Maker by ID.
DELETE /maker/delete/{id}: Delete a Maker by ID.

Products Endpoints:
GET /product/findAll: Get all Products.
GET /product/findById/{id}: Get a Product by ID.
GET /product/range/{min}/{max}: Get Products within a price range.
POST /product/save: Add a new Product.
PUT /product/update/{id}: Update a Product by ID.

Relationship Rules
A Product must be associated with a Maker (referenced by the maker_id field).
There should be no Products without an associated Maker.
