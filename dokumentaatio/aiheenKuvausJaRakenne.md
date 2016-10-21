## Aihemäärittely

**Aihe:** Ohjelma, joka tulostaa näytölle coolisti käyttäjän koodia hänen
määrittelemästä lähteestä...ehkä myös mahdollisuus vaikuttaa ohjelman graafisen esityksen
kulkuun lennosta? Tarkoitus olisi myös luoda käyttöliittymä ohjelman configurointiin.

**Käyttäjät:** Ohjelmoinnista innostuneet.

**Käyttäjien toiminnot:**

	* Pelata snake ja räjähdys pelia.
	* Piirtää ohjelmalla.
	* Vaihdella piirto teemoja.
	
	
**UML kaavio:**

![uml](UML.png)

**Rakennekuvaus:**
Ohjelmassa on 2 luokkaa kayttoliittymässä, 3 logiikassa ja 1 ohjauksessa. Logiikassa luodaan välineet tiedostojen hakuun TiedostonLuku luokassa, käsitellään virheet ja lopetus VirheetJaSiivous luokassa ja hallinnoidaan palloa Pallo puokassa. Ohjaaja välittää käskyjä
käyttöliittymälle, logiikalle ja niiden välillä. Käyttöliittymä paketissa saatu data manipuloidaan sopivaksi Piirtopaneelissa ja näytetään graafisesti erilaisten piirto metodien avulla. Naytto luokka luo näytön ja kuuntelee tapahtuma välittäen tiedot niistä 
ohjaajalle, joka taas välittää ne eteenpäin oikeille tahoille. Aja luokka luo tarvittavat luokat ja käynnistää ohjelman Ohjauksen kautta.


**Sekvenssikaavio datan hakemisesta ja esittämisestä:**

![sekvenssi2](Sekvenssi.png)


**Sekvenssikaavio käyttötapauksesta; virheen ilmoitus:**

![sekvenssi1](Sekvenssi5.png)


	


