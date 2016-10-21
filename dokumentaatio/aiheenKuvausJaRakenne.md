## Aihem��rittely

**Aihe:** Ohjelma, joka tulostaa n�yt�lle coolisti k�ytt�j�n koodia h�nen
m��rittelem�st� l�hteest�...ehk� my�s mahdollisuus vaikuttaa ohjelman graafisen esityksen
kulkuun lennosta? Tarkoitus olisi my�s luoda k�ytt�liittym� ohjelman configurointiin.

**K�ytt�j�t:** Ohjelmoinnista innostuneet.

**K�ytt�jien toiminnot:**

	* Pelata snake ja r�j�hdys pelia.
	* Piirt�� ohjelmalla.
	* Vaihdella piirto teemoja.
	
	
**UML kaavio:**

![uml](UML.png)

**Rakennekuvaus:**
Ohjelmassa on 2 luokkaa kayttoliittym�ss�, 3 logiikassa ja 1 ohjauksessa. Logiikassa luodaan v�lineet tiedostojen hakuun TiedostonLuku luokassa, k�sitell��n virheet ja lopetus VirheetJaSiivous luokassa ja hallinnoidaan palloa Pallo puokassa. Ohjaaja v�litt�� k�skyj�
k�ytt�liittym�lle, logiikalle ja niiden v�lill�. K�ytt�liittym� paketissa saatu data manipuloidaan sopivaksi Piirtopaneelissa ja n�ytet��n graafisesti erilaisten piirto metodien avulla. Naytto luokka luo n�yt�n ja kuuntelee tapahtuma v�litt�en tiedot niist� 
ohjaajalle, joka taas v�litt�� ne eteenp�in oikeille tahoille. Aja luokka luo tarvittavat luokat ja k�ynnist�� ohjelman Ohjauksen kautta.


**Sekvenssikaavio datan hakemisesta ja esitt�misest�:**

![sekvenssi2](Sekvenssi.png)


**Sekvenssikaavio k�ytt�tapauksesta; virheen ilmoitus:**

![sekvenssi1](Sekvenssi5.png)


	


