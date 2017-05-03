SELECT D.indirizzo 
FROM Distributore as D 
WHERE GeoDistance(:myLat,:myLon,D.lat,D.lon)<:distance