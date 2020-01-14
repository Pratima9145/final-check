-- Include table data insertion, updation, deletion and select scripts

-- -------------------------------------------------------------------
-- Adding Movie Items in MovieCruiser Table
-- -------------------------------------------------------------------
INSERT INTO movie_item
VALUES 
(1, 'Avatar', 2787965087, 'Yes', '2017-03-15','Science Fiction', 'Yes'),
(2, 'The Avengers', 1518812988, 'Yes', '2017-12-23', 'Superhero', 'No'),
(3, 'Titanic', 2187463944, 'Yes','2017-08-21', 'Romance', 'No'),
(4, 'Jurassic World', 1671713208, 'No','2017-07-02','Science Fiction', 'Yes'),
(5, 'Avengers: End Game', 2750760348, 'Yes', '2022-11-02','Superhero', 'Yes');

-- ---------------------------------------------------------
-- Displaying Movie Items --
-- -----------------------------------------------------------------
select 
movie_title as Title,
movie_gross as Gross,
movie_active as Active,
movie_date_of_launch as Date_of_Launch,
movie_genre as Genre,
movie_has_teaser as Has_Teaser
from movie_item;

-- -------------------------------------------------------------------
-- Edit Movie Items in Movie Cruiser Table
-- -------------------------------------------------------------------
update movie_item 
set movie_title='The Gentlemen',movie_gross=2589631478,movie_genre='Action Crime'
where movie_id=1;

-- -------------------------------------------------------------------
-- Displaying Updated movies in Movie Cruiser Table
-- -------------------------------------------------------------------
select 
movie_title as Title,
movie_gross as Gross,
movie_active as Active,
movie_date_of_launch as Date_of_Launch,
movie_genre as Genre,
movie_has_teaser as Has_Teaser
from movie_item;

-- -------------------------------------------------------------------
-- Displaying Customer Movie List in MovieItem Table
-- -------------------------------------------------------------------
select movie_title as Title,
movie_gross as Gross,
movie_genre as Genre,
movie_has_teaser as Has_Teaser
from movie_item
where movie_active='Yes' 
and movie_date_of_launch <= current_date();

-- -------------------------------------------------------------------
--  setting User Name and Id
-- -------------------------------------------------------------------
INSERT INTO user 
VALUES
(1,'Vinayak'),
(2,'Asha');

-- ---------------------------------------------------------
-- Displaying User Selected Items 
-- -----------------------------------------------------------------
select us_id as User_Id,
us_title as User_Title
from user;

-- -------------------------------------------------------------------
--  Add to Favorites Table
-- -------------------------------------------------------------------
insert into favorites(ft_us_id,ft_pr_id) 
values(2,1),(2,2),(2,5),(2,1),(1,1),(1,4);

-- -------------------------------------------------------------------
--  ViewFavorites Movie Items
-- -------------------------------------------------------------------
select 
ft_id as Id,
ft_us_id as User_Id,
ft_pr_id as Movie_Id
from favorites;

-- -------------------------------------------------------------------
--  Show Favorites Movie Items
-- -------------------------------------------------------------------
SELECT movie_title as Title,
movie_gross as Gross,
movie_genre as Genre
FROM movie_item 
INNER JOIN favorites
ON ft_pr_id=movie_id
WHERE ft_us_id=2;


-- -----------------------------------------------------------------
-- Displaying User Movie Items
-- -----------------------------------------------------------------
select ft_id as Title,
ft_us_id as Gross,
ft_pr_id as Genre
from favorites;

-- -------------------------------------------------------------------
--  Total Price of Favorites Movie Items
-- -------------------------------------------------------------------
select count(movie_title) as no_of_favorites 
from movie_item
inner join favorites
on ft_pr_id=movie_id
where ft_us_id=2; 

-- -----------------------------------------------------
-- Delete Favorite Items from Favorites Table
-- -----------------------------------------------------
delete from favorites
where ft_us_id=2
and ft_pr_id=1
limit 1; 

-- -------------------------------------------------------------------
--  View Remove Favorites
-- -------------------------------------------------------------------
SELECT movie_title as Title,
movie_gross as Gross,
movie_genre as Genre
FROM movie_item  
INNER JOIN favorites 
ON ft_pr_id=movie_id
WHERE ft_us_id=2;

-- -------------------------------------------------------------------
--  Show Total Number of Favorites Items
-- -------------------------------------------------------------------
select count(movie_title) as no_of_favorites 
from movie_item
inner join favorites on ft_pr_id=movie_id
where ft_us_id=2; 
 

