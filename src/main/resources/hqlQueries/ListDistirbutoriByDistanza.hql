select  d.id,d.lat,d.lon,d.indirizzo,d.posizioneEdificio, group_concat(C.nome) 
from Distributore as d join d.categorieFornites as CF join CF.categoria as C 
where ( d.lat - :lat < :distanza ) and  ( d.lon - :lon < :distanza ) and C.nome != 'Generica' 
group by d.id