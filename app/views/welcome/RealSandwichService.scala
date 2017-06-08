package views.welcome

import com.google.inject.ImplementedBy
import models.Sandwich

import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import uk.gov.hmrc.play.http.HeaderCarrier
import uk.gov.hmrc.play.http.ws.WSGet

class RealSandwichService extends SandwichService {

  val http = new WSGet {
    override val hooks = NoneRequired
  }
  override def sandwiches: Future[List[Sandwich]] = {
    implicit val hc = HeaderCarrier()
    http.GET[List[Sandwich]]("http://46.101.73.211:3000/sandwiches")
  }
}
  @ImplementedBy(classOf[RealSandwichService])
  trait SandwichService {
    def sandwiches(): Future[List[Sandwich]]
  }

