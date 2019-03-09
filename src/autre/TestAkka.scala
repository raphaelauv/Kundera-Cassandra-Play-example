object TestAkka {
  import akka.actor._
  import akka.event.Logging
  case class ServiceContre(qui: ActorRef)
  case class Balle(lifte: Boolean)
  case class BalleManque()

  case class TuAsGagner()
  case class organiseMatch(nomJ1: String, nomj2: String)
  
  class JoueurTennis extends Actor {
    val log = Logging(context.system, this)  
    def receive = {

      case ServiceContre(adv) =>
        log.info(self.path + " je recois un Service")
        log.info(self.path + " je renvois une balle")
        Thread.sleep(3000)
        adv ! Balle(false)

      case Balle(_) =>
        log.info(self.path + " je recois une balle")

        Thread.sleep(3000)

        if (Math.random() > 0.8) {
          log.info(self.path + " je RATE la balle")
          context.parent ! BalleManque()
          sender ! TuAsGagner()
          context.stop(self)
        } else {
          log.info(self.path + " je renvois une balle")
          sender ! Balle(false)
        }

      case TuAsGagner() =>
        log.info(self.path + " je GAGNE")
        context.stop(self)

    }

  }

  class Arbitre extends Actor {
    var nj1 = ""
    var nj2 = ""
    var gagnant = "personne"
    val log = Logging(context.system, this)
    def receive = {

      case organiseMatch(namej1, namej2) => {
        nj1 = namej1
        nj2 = namej2
        val joueur1 = context.actorOf(Props[JoueurTennis], name = nj1)
        val joueur2 = context.actorOf(Props[JoueurTennis], name = nj2)

        
        log.info(self.path + " je LANCE LE MATCH")
        joueur1 ! ServiceContre(joueur2)
      }
      case BalleManque() => {
        if (sender.path.name == nj1) {
          gagnant = nj2
        } else {
          gagnant = nj1
        }
        log.info(self.path + "LE MATCH EST FINI à gagner "+gagnant)
        context.stop(self)
      }
    }
  }

  def main(argc: Array[String]) {
    println("TOTO");

    val system = ActorSystem("match")

    val arbitre = system.actorOf(Props[Arbitre], name = "arbitre")

    arbitre ! organiseMatch("nadal", "federer")
    
  }

}
