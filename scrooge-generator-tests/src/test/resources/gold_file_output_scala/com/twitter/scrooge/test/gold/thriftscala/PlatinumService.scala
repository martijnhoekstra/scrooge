/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 */
package com.twitter.scrooge.test.gold.thriftscala

import com.twitter.scrooge.{
  LazyTProtocol,
  HasThriftStructCodec3,
  TFieldBlob,
  ThriftService,
  ThriftStruct,
  ThriftStructCodec,
  ThriftStructCodec3,
  ThriftStructFieldInfo,
  ThriftResponse,
  ThriftUtil,
  ToThriftService
}
import com.twitter.finagle.{service => ctfs}
import com.twitter.finagle.thrift.{Protocols, ThriftClientRequest, ThriftServiceIface}
import com.twitter.util.Future
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.transport.TTransport
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.TMemoryBuffer
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.{
  Builder,
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}
import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
trait PlatinumService[+MM[_]] extends GoldService[MM] {

  def moreCoolThings(request: com.twitter.scrooge.test.gold.thriftscala.Request): MM[Int]
}


object PlatinumService { self =>

  val annotations: immutable$Map[String, String] = immutable$Map.empty

  trait BaseServiceIface extends com.twitter.scrooge.test.gold.thriftscala.GoldService.BaseServiceIface {
    def moreCoolThings : com.twitter.finagle.Service[self.MoreCoolThings.Args, self.MoreCoolThings.SuccessType]

    override def toThriftService: ThriftService = new MethodIface(this)
  }

  case class ServiceIface(
      moreCoolThings : com.twitter.finagle.Service[self.MoreCoolThings.Args, self.MoreCoolThings.SuccessType],
      doGreatThings : com.twitter.finagle.Service[com.twitter.scrooge.test.gold.thriftscala.GoldService.DoGreatThings.Args, com.twitter.scrooge.test.gold.thriftscala.GoldService.DoGreatThings.SuccessType]
  ) extends com.twitter.scrooge.test.gold.thriftscala.GoldService.BaseServiceIface
    with BaseServiceIface
    with com.twitter.finagle.thrift.ThriftServiceIface.Filterable[ServiceIface] {

    /**
     * Prepends the given type-agnostic `Filter` to all of the `Services`
     * and returns a copy of the `ServiceIface` now including the filter.
     */
    def filtered(filter: com.twitter.finagle.Filter.TypeAgnostic): ServiceIface =
      copy(
        moreCoolThings = filter.toFilter.andThen(moreCoolThings),
        doGreatThings = filter.toFilter.andThen(doGreatThings)
      )
  }

  implicit object ServiceIfaceBuilder
    extends com.twitter.finagle.thrift.ServiceIfaceBuilder[ServiceIface] {
      def newServiceIface(
        binaryService: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
        pf: TProtocolFactory = com.twitter.finagle.thrift.Protocols.binaryFactory(),
        stats: com.twitter.finagle.stats.StatsReceiver
      ): ServiceIface =
        ServiceIface(
          moreCoolThings = ThriftServiceIface(self.MoreCoolThings, binaryService, pf, stats),
          doGreatThings = ThriftServiceIface(com.twitter.scrooge.test.gold.thriftscala.GoldService.DoGreatThings, binaryService, pf, stats)
        )
  }

  class MethodIface(serviceIface: BaseServiceIface)
    extends com.twitter.scrooge.test.gold.thriftscala.GoldService.MethodIface(serviceIface)
    with PlatinumService[Future] {
    def moreCoolThings(request: com.twitter.scrooge.test.gold.thriftscala.Request): Future[Int] =
      serviceIface.moreCoolThings(self.MoreCoolThings.Args(request))
  }

  implicit object MethodIfaceBuilder
    extends com.twitter.finagle.thrift.MethodIfaceBuilder[ServiceIface, PlatinumService[Future]] {
    def newMethodIface(serviceIface: ServiceIface): MethodIface =
      new MethodIface(serviceIface)
  }

  object MoreCoolThings extends com.twitter.scrooge.ThriftMethod {

    object Args extends ThriftStructCodec3[Args] {
      private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
      val Struct = new TStruct("moreCoolThings_args")
      val RequestField = new TField("request", TType.STRUCT, 1)
      val RequestFieldManifest = implicitly[Manifest[com.twitter.scrooge.test.gold.thriftscala.Request]]

      /**
       * Field information in declaration order.
       */
      lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
        new ThriftStructFieldInfo(
          RequestField,
          false,
          false,
          RequestFieldManifest,
          _root_.scala.None,
          _root_.scala.None,
          immutable$Map.empty[String, String],
          immutable$Map.empty[String, String],
          None
        )
      )

      lazy val structAnnotations: immutable$Map[String, String] =
        immutable$Map.empty[String, String]

      /**
       * Checks that all required fields are non-null.
       */
      def validate(_item: Args): Unit = {
      }

      def withoutPassthroughFields(original: Args): Args =
        new Args(
          request =
            {
              val field = original.request
              com.twitter.scrooge.test.gold.thriftscala.Request.withoutPassthroughFields(field)
            }
        )

      override def encode(_item: Args, _oproto: TProtocol): Unit = {
        _item.write(_oproto)
      }

      override def decode(_iprot: TProtocol): Args = {
        var request: com.twitter.scrooge.test.gold.thriftscala.Request = null
        var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
        var _done = false

        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 1 =>
                _field.`type` match {
                  case TType.STRUCT =>
                    request = readRequestValue(_iprot)
                  case _actualType =>
                    val _expectedType = TType.STRUCT
                    throw new TProtocolException(
                      "Received wrong type for field 'request' (expected=%s, actual=%s).".format(
                        ttypeToString(_expectedType),
                        ttypeToString(_actualType)
                      )
                    )
                }
              case _ =>
                if (_passthroughFields == null)
                  _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
                _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()

        new Args(
          request,
          if (_passthroughFields == null)
            NoPassthroughFields
          else
            _passthroughFields.result()
        )
      }

      def apply(
        request: com.twitter.scrooge.test.gold.thriftscala.Request
      ): Args =
        new Args(
          request
        )

      def unapply(_item: Args): _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = _root_.scala.Some(_item.request)


      @inline private def readRequestValue(_iprot: TProtocol): com.twitter.scrooge.test.gold.thriftscala.Request = {
        com.twitter.scrooge.test.gold.thriftscala.Request.decode(_iprot)
      }

      @inline private def writeRequestField(request_item: com.twitter.scrooge.test.gold.thriftscala.Request, _oprot: TProtocol): Unit = {
        _oprot.writeFieldBegin(RequestField)
        writeRequestValue(request_item, _oprot)
        _oprot.writeFieldEnd()
      }

      @inline private def writeRequestValue(request_item: com.twitter.scrooge.test.gold.thriftscala.Request, _oprot: TProtocol): Unit = {
        request_item.write(_oprot)
      }


    }

    class Args(
        val request: com.twitter.scrooge.test.gold.thriftscala.Request,
        val _passthroughFields: immutable$Map[Short, TFieldBlob])
      extends ThriftStruct
      with _root_.scala.Product1[com.twitter.scrooge.test.gold.thriftscala.Request]
      with HasThriftStructCodec3[Args]
      with java.io.Serializable
    {
      import Args._
      def this(
        request: com.twitter.scrooge.test.gold.thriftscala.Request
      ) = this(
        request,
        Map.empty
      )

      def _1 = request



      override def write(_oprot: TProtocol): Unit = {
        Args.validate(this)
        _oprot.writeStructBegin(Struct)
        if (request ne null) writeRequestField(request, _oprot)
        if (_passthroughFields.nonEmpty) {
          _passthroughFields.values.foreach { _.write(_oprot) }
        }
        _oprot.writeFieldStop()
        _oprot.writeStructEnd()
      }

      def copy(
        request: com.twitter.scrooge.test.gold.thriftscala.Request = this.request,
        _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
      ): Args =
        new Args(
          request,
          _passthroughFields
        )

      override def canEqual(other: Any): Boolean = other.isInstanceOf[Args]

      private def _equals(x: Args, y: Args): Boolean =
          x.productArity == y.productArity &&
          x.productIterator.sameElements(y.productIterator)

      override def equals(other: Any): Boolean =
        canEqual(other) &&
          _equals(this, other.asInstanceOf[Args]) &&
          _passthroughFields == other.asInstanceOf[Args]._passthroughFields

      override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

      override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


      override def productArity: Int = 1

      override def productElement(n: Int): Any = n match {
        case 0 => this.request
        case _ => throw new IndexOutOfBoundsException(n.toString)
      }

      override def productPrefix: String = "Args"

      def _codec: ThriftStructCodec3[Args] = Args
    }

    type SuccessType = Int

    object Result extends ThriftStructCodec3[Result] {
      private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
      val Struct = new TStruct("moreCoolThings_result")
      val SuccessField = new TField("success", TType.I32, 0)
      val SuccessFieldManifest = implicitly[Manifest[Int]]
      val AxField = new TField("ax", TType.STRUCT, 1)
      val AxFieldManifest = implicitly[Manifest[com.twitter.scrooge.test.gold.thriftscala.AnotherException]]
      val OceField = new TField("oce", TType.STRUCT, 2)
      val OceFieldManifest = implicitly[Manifest[com.twitter.scrooge.test.gold.thriftscala.OverCapacityException]]

      /**
       * Field information in declaration order.
       */
      lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
        new ThriftStructFieldInfo(
          SuccessField,
          true,
          false,
          SuccessFieldManifest,
          _root_.scala.None,
          _root_.scala.None,
          immutable$Map.empty[String, String],
          immutable$Map.empty[String, String],
          None
        ),
        new ThriftStructFieldInfo(
          AxField,
          true,
          false,
          AxFieldManifest,
          _root_.scala.None,
          _root_.scala.None,
          immutable$Map.empty[String, String],
          immutable$Map.empty[String, String],
          None
        ),
        new ThriftStructFieldInfo(
          OceField,
          true,
          false,
          OceFieldManifest,
          _root_.scala.None,
          _root_.scala.None,
          immutable$Map.empty[String, String],
          immutable$Map.empty[String, String],
          None
        )
      )

      lazy val structAnnotations: immutable$Map[String, String] =
        immutable$Map.empty[String, String]

      /**
       * Checks that all required fields are non-null.
       */
      def validate(_item: Result): Unit = {
      }

      def withoutPassthroughFields(original: Result): Result =
        new Result(
          success =
            {
              val field = original.success
              field.map { field =>
                field
              }
            },
          ax =
            {
              val field = original.ax
              field.map { field =>
                com.twitter.scrooge.test.gold.thriftscala.AnotherException.withoutPassthroughFields(field)
              }
            },
          oce =
            {
              val field = original.oce
              field.map { field =>
                com.twitter.scrooge.test.gold.thriftscala.OverCapacityException.withoutPassthroughFields(field)
              }
            }
        )

      override def encode(_item: Result, _oproto: TProtocol): Unit = {
        _item.write(_oproto)
      }

      override def decode(_iprot: TProtocol): Result = {
        var success: _root_.scala.Option[Int] = _root_.scala.None
        var ax: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.AnotherException] = _root_.scala.None
        var oce: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.OverCapacityException] = _root_.scala.None
        var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
        var _done = false

        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 =>
                _field.`type` match {
                  case TType.I32 =>
                    success = _root_.scala.Some(readSuccessValue(_iprot))
                  case _actualType =>
                    val _expectedType = TType.I32
                    throw new TProtocolException(
                      "Received wrong type for field 'success' (expected=%s, actual=%s).".format(
                        ttypeToString(_expectedType),
                        ttypeToString(_actualType)
                      )
                    )
                }
              case 1 =>
                _field.`type` match {
                  case TType.STRUCT =>
                    ax = _root_.scala.Some(readAxValue(_iprot))
                  case _actualType =>
                    val _expectedType = TType.STRUCT
                    throw new TProtocolException(
                      "Received wrong type for field 'ax' (expected=%s, actual=%s).".format(
                        ttypeToString(_expectedType),
                        ttypeToString(_actualType)
                      )
                    )
                }
              case 2 =>
                _field.`type` match {
                  case TType.STRUCT =>
                    oce = _root_.scala.Some(readOceValue(_iprot))
                  case _actualType =>
                    val _expectedType = TType.STRUCT
                    throw new TProtocolException(
                      "Received wrong type for field 'oce' (expected=%s, actual=%s).".format(
                        ttypeToString(_expectedType),
                        ttypeToString(_actualType)
                      )
                    )
                }
              case _ =>
                if (_passthroughFields == null)
                  _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
                _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()

        new Result(
          success,
          ax,
          oce,
          if (_passthroughFields == null)
            NoPassthroughFields
          else
            _passthroughFields.result()
        )
      }

      def apply(
        success: _root_.scala.Option[Int] = _root_.scala.None,
        ax: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.AnotherException] = _root_.scala.None,
        oce: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.OverCapacityException] = _root_.scala.None
      ): Result =
        new Result(
          success,
          ax,
          oce
        )

      def unapply(_item: Result): _root_.scala.Option[_root_.scala.Tuple3[Option[Int], Option[com.twitter.scrooge.test.gold.thriftscala.AnotherException], Option[com.twitter.scrooge.test.gold.thriftscala.OverCapacityException]]] = _root_.scala.Some(_item.toTuple)


      @inline private def readSuccessValue(_iprot: TProtocol): Int = {
        _iprot.readI32()
      }

      @inline private def writeSuccessField(success_item: Int, _oprot: TProtocol): Unit = {
        _oprot.writeFieldBegin(SuccessField)
        writeSuccessValue(success_item, _oprot)
        _oprot.writeFieldEnd()
      }

      @inline private def writeSuccessValue(success_item: Int, _oprot: TProtocol): Unit = {
        _oprot.writeI32(success_item)
      }

      @inline private def readAxValue(_iprot: TProtocol): com.twitter.scrooge.test.gold.thriftscala.AnotherException = {
        com.twitter.scrooge.test.gold.thriftscala.AnotherException.decode(_iprot)
      }

      @inline private def writeAxField(ax_item: com.twitter.scrooge.test.gold.thriftscala.AnotherException, _oprot: TProtocol): Unit = {
        _oprot.writeFieldBegin(AxField)
        writeAxValue(ax_item, _oprot)
        _oprot.writeFieldEnd()
      }

      @inline private def writeAxValue(ax_item: com.twitter.scrooge.test.gold.thriftscala.AnotherException, _oprot: TProtocol): Unit = {
        ax_item.write(_oprot)
      }

      @inline private def readOceValue(_iprot: TProtocol): com.twitter.scrooge.test.gold.thriftscala.OverCapacityException = {
        com.twitter.scrooge.test.gold.thriftscala.OverCapacityException.decode(_iprot)
      }

      @inline private def writeOceField(oce_item: com.twitter.scrooge.test.gold.thriftscala.OverCapacityException, _oprot: TProtocol): Unit = {
        _oprot.writeFieldBegin(OceField)
        writeOceValue(oce_item, _oprot)
        _oprot.writeFieldEnd()
      }

      @inline private def writeOceValue(oce_item: com.twitter.scrooge.test.gold.thriftscala.OverCapacityException, _oprot: TProtocol): Unit = {
        oce_item.write(_oprot)
      }


    }

    class Result(
        val success: _root_.scala.Option[Int],
        val ax: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.AnotherException],
        val oce: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.OverCapacityException],
        val _passthroughFields: immutable$Map[Short, TFieldBlob])
      extends ThriftResponse[Int] with ThriftStruct
      with _root_.scala.Product3[Option[Int], Option[com.twitter.scrooge.test.gold.thriftscala.AnotherException], Option[com.twitter.scrooge.test.gold.thriftscala.OverCapacityException]]
      with HasThriftStructCodec3[Result]
      with java.io.Serializable
    {
      import Result._
      def this(
        success: _root_.scala.Option[Int] = _root_.scala.None,
        ax: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.AnotherException] = _root_.scala.None,
        oce: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.OverCapacityException] = _root_.scala.None
      ) = this(
        success,
        ax,
        oce,
        Map.empty
      )

      def _1 = success
      def _2 = ax
      def _3 = oce

      def toTuple: _root_.scala.Tuple3[Option[Int], Option[com.twitter.scrooge.test.gold.thriftscala.AnotherException], Option[com.twitter.scrooge.test.gold.thriftscala.OverCapacityException]] = {
        (
          success,
          ax,
          oce
        )
      }

      def successField: Option[Int] = success
      def exceptionFields: Iterable[Option[com.twitter.scrooge.ThriftException]] = Seq(ax, oce)


      override def write(_oprot: TProtocol): Unit = {
        Result.validate(this)
        _oprot.writeStructBegin(Struct)
        if (success.isDefined) writeSuccessField(success.get, _oprot)
        if (ax.isDefined) writeAxField(ax.get, _oprot)
        if (oce.isDefined) writeOceField(oce.get, _oprot)
        if (_passthroughFields.nonEmpty) {
          _passthroughFields.values.foreach { _.write(_oprot) }
        }
        _oprot.writeFieldStop()
        _oprot.writeStructEnd()
      }

      def copy(
        success: _root_.scala.Option[Int] = this.success,
        ax: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.AnotherException] = this.ax,
        oce: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.OverCapacityException] = this.oce,
        _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
      ): Result =
        new Result(
          success,
          ax,
          oce,
          _passthroughFields
        )

      override def canEqual(other: Any): Boolean = other.isInstanceOf[Result]

      private def _equals(x: Result, y: Result): Boolean =
          x.productArity == y.productArity &&
          x.productIterator.sameElements(y.productIterator)

      override def equals(other: Any): Boolean =
        canEqual(other) &&
          _equals(this, other.asInstanceOf[Result]) &&
          _passthroughFields == other.asInstanceOf[Result]._passthroughFields

      override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

      override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


      override def productArity: Int = 3

      override def productElement(n: Int): Any = n match {
        case 0 => this.success
        case 1 => this.ax
        case 2 => this.oce
        case _ => throw new IndexOutOfBoundsException(n.toString)
      }

      override def productPrefix: String = "Result"

      def _codec: ThriftStructCodec3[Result] = Result
    }

    val annotations: immutable$Map[String, String] = immutable$Map.empty

    type FunctionType = Function1[Args,Future[Int]]
    type ServiceType = com.twitter.finagle.Service[Args, Result]

    type ServiceIfaceServiceType = com.twitter.finagle.Service[Args, SuccessType]

    def toServiceIfaceService(f: FunctionType): ServiceIfaceServiceType =
      com.twitter.finagle.Service.mk { args: Args =>
        f(args)
      }

    private[this] val toResult = (res: SuccessType) => Result(Some(res))

    def functionToService(f: FunctionType): ServiceType =
      com.twitter.finagle.Service.mk { args: Args =>
        f(args).map(toResult)
      }

    def serviceToFunction(svc: ServiceType): FunctionType = { args: Args =>
      com.twitter.finagle.thrift.ThriftServiceIface.resultFilter(this).andThen(svc).apply(args)
    }

    val name: String = "moreCoolThings"
    val serviceName: String = "PlatinumService"
    val argsCodec = Args
    val responseCodec = Result
    val oneway: Boolean = false
  }

  // Compatibility aliases.
  val moreCoolThings$args = MoreCoolThings.Args
  type moreCoolThings$args = MoreCoolThings.Args

  val moreCoolThings$result = MoreCoolThings.Result
  type moreCoolThings$result = MoreCoolThings.Result


  trait FutureIface
    extends com.twitter.scrooge.test.gold.thriftscala.GoldService.FutureIface
    with PlatinumService[Future] {

    def moreCoolThings(request: com.twitter.scrooge.test.gold.thriftscala.Request): Future[Int]
  }

  class FinagledClient(
      service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
      protocolFactory: org.apache.thrift.protocol.TProtocolFactory = Protocols.binaryFactory(),
      serviceName: String = "PlatinumService",
      stats: com.twitter.finagle.stats.StatsReceiver = com.twitter.finagle.stats.NullStatsReceiver,
      responseClassifier: ctfs.ResponseClassifier = ctfs.ResponseClassifier.Default)
    extends PlatinumService$FinagleClient(
      service,
      protocolFactory,
      serviceName,
      stats,
      responseClassifier)
    with FutureIface {

    def this(
      service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
      protocolFactory: TProtocolFactory,
      serviceName: String,
      stats: com.twitter.finagle.stats.StatsReceiver
    ) = this(service, protocolFactory, serviceName, stats, ctfs.ResponseClassifier.Default)
  }

  class FinagledService(
      iface: FutureIface,
      protocolFactory: org.apache.thrift.protocol.TProtocolFactory)
    extends PlatinumService$FinagleService(
      iface,
      protocolFactory)
}