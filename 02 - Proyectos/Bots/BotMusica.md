import discord
from discord.ext import commands, tasks
import yt_dlp as youtube_dl
import asyncio

# Crea un bot de comandos
intents = discord.Intents.default()
intents.message_content = True
bot = commands.Bot(command_prefix='!', intents=intents)

# Define un diccionario para almacenar los reproductores de voz activos
voice_clients = {}

# Configurar la fuente de audio para transmitir música
class YTDLSource(discord.PCMVolumeTransformer):
    def __init__(self, source, *, data, volume=0.5):
        super().__init__(source, volume)
        self.data = data
        self.title = data.get('title')
        self.url = data.get('url')

    @classmethod
    async def from_url(cls, url, *, loop=None, stream=False):
        ydl_opts = {
            'format': 'bestaudio/best',
            'extractaudio': True,
            'audioquality': 1,
            'outtmpl': 'downloads/%(id)s.%(ext)s',
            'restrictfilenames': True,
            'noplaylist': True,
            'quiet': True,
            'logtostderr': False,
            'source_address': None,
        }

        loop = loop or asyncio.get_event_loop()

        with youtube_dl.YoutubeDL(ydl_opts) as ydl:
            info = ydl.extract_info(url, download=False)
            if 'entries' in info:
                info = info['entries'][0]
            return await cls.create_source(info['url'], loop=loop)

    @staticmethod
    async def create_source(url, loop=None):
        ydl_opts = {
            'format': 'bestaudio/best',
            'extractaudio': True,
            'audioquality': 1,
            'outtmpl': 'downloads/%(id)s.%(ext)s',
            'restrictfilenames': True,
            'noplaylist': True,
            'quiet': True,
            'logtostderr': False,
            'source_address': None,
        }
        loop = loop or asyncio.get_event_loop()

        with youtube_dl.YoutubeDL(ydl_opts) as ydl:
            info = ydl.extract_info(url, download=False)
            if 'entries' in info:
                info = info['entries'][0]
            return YTDLSource(None, data=info)


# Comando para conectar al canal de voz
@bot.command()
async def join(ctx):
    channel = ctx.author.voice.channel
    if channel:
        vc = await channel.connect()
        voice_clients[ctx.guild.id] = vc
    else:
        await ctx.send("Debes unirte a un canal de voz primero.")

# Comando para desconectar del canal de voz
@bot.command()
async def leave(ctx):
    if ctx.guild.id in voice_clients:
        vc = voice_clients.pop(ctx.guild.id)
        await vc.disconnect()
    else:
        await ctx.send("No estoy en ningún canal de voz.")

# Comando para reproducir música desde un enlace de Spotify o YouTube
@bot.command()
async def play(ctx, url):
    try:
        # Intentamos obtener el URL de Spotify
        voice_channel = ctx.author.voice.channel
        if ctx.guild.id not in voice_clients:
            await voice_channel.connect()

        # Usamos yt-dlp para obtener el audio desde el enlace de Spotify o YouTube
        voice_client = discord.utils.get(bot.voice_clients, guild=ctx.guild)
        audio_source = await YTDLSource.from_url(url, loop=bot.loop, stream=True)

        if voice_client.is_playing():
            voice_client.stop()

        voice_client.play(audio_source, after=lambda e: print('done', e))
        await ctx.send(f'Reproduciendo: {audio_source.title}')
    except Exception as e:
        print(f"Error: {e}")
        await ctx.send("Hubo un problema al intentar reproducir la música.")

# Comando para pausar la música
@bot.command()
async def pause(ctx):
    voice_client = discord.utils.get(bot.voice_clients, guild=ctx.guild)
    if voice_client.is_playing():
        voice_client.pause()
        await ctx.send("Música pausada.")
    else:
        await ctx.send("No estoy reproduciendo música.")

# Comando para reanudar la música
@bot.command()
async def resume(ctx):
    voice_client = discord.utils.get(bot.voice_clients, guild=ctx.guild)
    if voice_client.is_paused():
        voice_client.resume()
        await ctx.send("Reanudando la música.")
    else:
        await ctx.send("La música ya se está reproduciendo.")

# Comando para detener la música
@bot.command()
async def stop(ctx):
    voice_client = discord.utils.get(bot.voice_clients, guild=ctx.guild)
    if voice_client.is_playing():
        voice_client.stop()
        await ctx.send("Música detenida.")
    else:
        await ctx.send("No estoy reproduciendo música.")

# Comando para ver el estado del bot
@bot.command()
async def status(ctx):
    await ctx.send("El bot está en línea y listo para reproducir música.")

# Iniciar el bot con el token
bot.run('TU_TOKEN_DE_DISCORD')
