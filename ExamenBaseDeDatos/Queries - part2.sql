-- 1.	Generar script para poblar todas las tablas.

INSERT INTO public."Productos"("Nombre", "Precio")
	VALUES 	('Refresco', 15.00),
			('Dulces', 3.00),
			('Sabritas', 20.00),
			('Comida Enlatada', 30.00),
			('Cerveza', 25.00);

INSERT INTO public."Cajeros"("NomApels")
	VALUES 	('Jose Ojeda'),
			('Fernanda Garcia'),
			('Marcos Guzman'),
			('Lionel Messi'),
			('Cristiano Ronaldo'),
			('Mike Tyson');

INSERT INTO public."Maquinas_Registradoras"("Piso")
	VALUES 	(3),
			(4),
			(2),
			(7),
			(8),
			(13),
			(31);

INSERT INTO public."Venta"("Cajero", "Maquina", "Producto")
	VALUES 	(1,2,1),
			(2,1,4),
			(1,1,1),
			(1,5,3),
			(5,2,3);


-- 2.	Mostrar el número de ventas de cada producto, ordenado de más a menos ventas.

select COUNT(p."Producto") as Cantidad, p."Nombre" from "Productos" as p
join "Venta" as v on v."Producto" = p."Producto" 
group by p."Nombre"
order by cantidad desc

-- 3.	Obtener un informe completo de ventas, indicando el nombre del cajero que realizo la venta, nombre y precios de los productos vendidos, y el piso en el que se encuentra la máquina registradora donde se realizó la venta.

select "Productos"."Nombre" as Producto, "Productos"."Precio", "Cajeros"."NomApels" as Cajero, "Maquinas_Registradoras"."Piso" from "Venta"
join "Productos" on "Productos"."Producto" = "Venta"."Producto"
join "Cajeros" on "Cajeros"."Cajero" = "Venta"."Cajero"
join "Maquinas_Registradoras" on "Maquinas_Registradoras"."Maquina" = "Venta"."Maquina"

-- 4.	Obtener las ventas totales realizadas en cada piso.

select COUNT("Maquinas_Registradoras"."Maquina") as Total_De_Ventas, "Maquinas_Registradoras"."Piso" from "Maquinas_Registradoras"
join "Venta" on "Venta"."Maquina" = "Maquinas_Registradoras"."Maquina"
group by "Maquinas_Registradoras"."Piso"
order by Total_De_Ventas desc

-- 5.	Obtener el código y nombre de cada cajero junto con el importe total de sus ventas.

select "Cajeros"."Cajero" as Codigo_Cajero, "Cajeros"."NomApels" as Nombre_Cajero, SUM("Productos"."Precio") as Importe_Total from "Cajeros"
join "Venta" on "Venta"."Cajero" = "Cajeros"."Cajero"
join "Productos" on "Productos"."Producto" = "Venta"."Producto"
group by Codigo_Cajero, Nombre_Cajero
order by Importe_Total desc

-- 6.	Obtener el código y nombre de aquellos cajeros que hayan realizado ventas en pisos cuyas ventas totales sean inferiores a los 5000 pesos.

select "Cajeros"."Cajero" as Codigo_Cajero, "Cajeros"."NomApels" as Nombre_cajero, 
SUM("Productos"."Precio") as ventas_totales from "Maquinas_Registradoras"
join "Venta" on "Venta"."Maquina" = "Maquinas_Registradoras"."Maquina"
join "Cajeros" on "Cajeros"."Cajero" = "Venta"."Cajero"
join "Productos" on "Productos"."Producto" = "Venta"."Producto"
group by Codigo_Cajero,Nombre_cajero
having SUM("Productos"."Precio") < CAST(50 as money)