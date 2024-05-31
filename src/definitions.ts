export interface DataWedgePluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
