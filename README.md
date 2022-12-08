Les fondateurs souhaitent développer l'activité et vous avez entendu parler d'une nouvelle idée de produit : 
une appli qui permettrait aux clients de transférer de l'argent pour gérer leurs finances ou payer leurs amis.
Pendant que vous étiez en formation à l’extérieur, le directeur de l'entreprise a organisé une réunion pour mettre votre équipe au courant des besoins produit de cette nouvelle appli.
Votre équipe, composée de concepteurs UX, de développeurs d'interface, de développeurs d'infrastructure et d'un chef de projet, a été choisie pour transformer cette idée en un produit totalement fonctionnel que les gens adoreront utiliser.

![pmb](https://user-images.githubusercontent.com/67195863/201713596-10c50575-d468-4130-b9d8-3f99a81fa73c.png)

Objet : Synthèse produit Sprint 1  
De : Avinash Patel
À : Moi

Bonjour,

J'espère que ta formation s'est bien passée ! 

Puisque tu n'as pas pu participer à la réunion d'équipe, jette donc un œil au compte-rendu sur ce lien, pour te mettre au courant de la discussion du projet et des besoins. Anja, dans l'équipe UX, a déjà commencé à travailler sur les maquettes et les a partagés avec nous (tu les trouveras ci-dessous).  

J'aimerais que tu t'occupes de la conception de la base de données, de la couche Java DAL (avec la gestion des transactions commits/rollback) et de l’interface web pour le prototype du projet. Nous avons déjà fait la réunion de sprint initiale et avons placé tes tâches sur ce tableau. Pour le diagramme de classe UML et le schéma de modélisation de la base de données, tu peux les ajouter au fichier README de ton projet sur GitHub.

Pour l’implémentation de l’interface web, sers-toi des maquettes existantes comme base. Tu peux bien sûr utiliser un framework comme Bootstrap, au choix.  Etant donné qu’on est train de faire un prototype, le côté responsive n’est pas obligatoire. 

Suis bien les tâches Trello. L’interface web permettra de valider que ta couche DAL est bien implémentée. Attention, le travail attendu est uniquement le prototype, pour la V1 cela sera traité ultérieurement.

N'hésite pas à me joindre ou à t'adresser à quelqu'un d'autre de l'équipe si tu es coincé ou as besoin d'infos supplémentaires.

Sinon, dis-moi quand tu es prêt et j'étudierai le code avec toi.

Merci,

Avinash
Chef de projet chez Pay My Buddy

![maquette_transfert](https://user-images.githubusercontent.com/67195863/201714138-de32bfa7-9a49-460d-a822-7b21d26da6f2.png)
![maquette_login](https://user-images.githubusercontent.com/67195863/201714152-00525b2c-4768-4e2e-aeff-4ca0b92e6a0c.png)

Livrables
Le diagramme de classe UML, ajouté au fichier README sur GitHub, explicitant la structure des classes du modèle.
Le modèle physique de données, ajouté au fichier README sur GitHub, explicitant la structure des tables de la base de données.
Les scripts SQL de base de données, enregistrés dans au fichier sur GitHub, pour les tables et autres objets de support que vous souhaitez utiliser, par exemple des séquences.
Un document TXT contenant le lien vers le repository GitHub contenant le code de votre application web basée sur Java qui inclut :
une couche DAL/référentiel pour interagir avec les tables de la base de données ;
une méthode sécurisée de connexion à la base de données depuis le code ;
la gestion des transactions (commits et rollback) ;
une interface web se basant sur les maquettes et exploitant la couche DAL.
Pour faciliter votre passage devant le jury, déposez sur la plateforme, dans un dossier zip nommé “Titre_du_projet_nom_prénom”, avec tous les livrables du projet comme suit : Nom_Prénom_n° du livrable_nom du livrable_date de démarrage du projet. Cela donnera : 

Compétences évaluées
Implémenter un schéma de données dans une base relationnelle
Concevoir l'architecture technique d'une application à l'aide de diagramme UML
Construire une application web java avec le pattern repository
Réaliser un schéma de conception de la base de données de l’application

![uml](https://user-images.githubusercontent.com/67195863/206509162-67c880cf-7189-4a6c-b57f-df61b320af02.png)
![bdd](https://user-images.githubusercontent.com/67195863/206509220-794ebc2f-ef76-4cbb-9e95-6cbf4586644a.png)

