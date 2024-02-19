

from requests_html import HTMLSession
#imports requests html



#print(1) #test to see if compiles


s = HTMLSession() #creates s object equal to session?

query = 'north bend'
url = f'https://www.google.com/search?q=weather+{query}'
#f is used to insert a variable into the string
#allows us to search an area for weather

r = s.get(url, headers = {'User-Agent' : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36'})
#this is so google doesnt think you are a robot


#print(r.html.find('title', first = True).text)
#html.find returns the element it is looking for


temp = r.html.find('span#wob_tm', first = True).text #gives the temp
#need to put span# before the id, idk why


#"vk_bk wob-unit" class for degree unit
# replace spaces with a '.'
#print(r.html.find('div.vk_bk.wob-unit'))
# ^this returns the element
unit = r.html.find('div.vk_bk.wob-unit span.wob_t', first = True).text #returns the unit of measurment
#"div"_ "span" means first searcher for _ then _ within _

desc = r.html.find('div.wob_dcp span#wob_dc', first = True).text # one way of searching for a span within a div
# print(r.html.find('div.wob_dcp', first = True).find('span#wob_dc', first = True).text) # another way using . find

#read about html session to see how it works

print('temp in ' + query, temp, unit, desc)