package monaco

package services {

  import scala.scalajs.js
  import scala.scalajs.js.annotation.ScalaJSDefined
  import monaco.common.IReference
  import monaco.editor.IEditor
  import monaco.editor.IModel
  import monaco.editor.IResourceInput

  @ScalaJSDefined
  trait ITextModelContentProvider extends js.Object {
    def provideTextContent(resource: Uri): Promise[IModel]
  }

  @ScalaJSDefined
  trait ITextModelService extends js.Object {
    def registerTextModelContentProvider(
        scheme: String,
        provider: ITextModelContentProvider
    ): IDisposable
  }

  @ScalaJSDefined
  trait IEditorService extends js.Object {
    def openEditor(
        input: IResourceInput,
        sideBySide: js.UndefOr[Boolean]
    ): Promise[IEditor]
  }

  // NOTE: This service got recently renamed to ITextModelService
  // see https://github.com/Microsoft/vscode/commit/337ded059ae5140b86caf07e67ce92a41a8e6581
  // We will need to update correspondingly when upgrading monaco.
  @ScalaJSDefined
  trait ITextModelResolverService extends js.Object {
    def createModelReference(
        resource: Uri
    ): Promise[IReference[ITextEditorModel]]
  }

  @ScalaJSDefined
  trait ITextEditorModel extends js.Object {
    def textEditorModel: IModel
  }

  object ITextEditorModel {
    def apply(model: IModel): ITextEditorModel = new ITextEditorModel {
      override def textEditorModel: IModel = model
    }
  }
}